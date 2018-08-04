package com.example.android.android_artonmobileapp;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.content.CursorLoader;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.android_artonmobileapp.adapter.FavItemsAdapter;
import com.example.android.android_artonmobileapp.data.ArtObjectsContract;
import com.example.android.android_artonmobileapp.holder.FavItemViewHolder;
import com.example.android.android_artonmobileapp.model.ArtObject;
import com.example.android.android_artonmobileapp.utils.Config;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.android.android_artonmobileapp.adapter.FavItemsAdapter.FAV_OBJECTS_PROJECTION;
import static com.example.android.android_artonmobileapp.utils.Config.ID_FAV_ITEMS_LOADER;

public class FavActivity extends AppCompatActivity implements FavItemViewHolder.FavItemsAdapterOnClickHandler, LoaderManager.LoaderCallbacks<Cursor>  {
    @BindView(R.id.items1_rv)
    RecyclerView mRecyclerView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private List<ArtObject> mItems;
    /*   @BindView(R.id.pb_loading_indicator)
       ProgressBar mLoadingIndicator;
       @BindView(R.id.tv_error_message_display)
       TextView mErrorMessageDisplay;
       @BindView(R.id.tv_no_fav_art_objects)
       TextView mNoFavArtObjectsView;
      */
    private int mPosition = RecyclerView.NO_POSITION;
    private FavItemsAdapter mFavItemsAdapter;
    private Parcelable mSavedRecyclerLayoutState;
    private GridLayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mFavItemsAdapter = new FavItemsAdapter(this, this);
        mLayoutManager = new GridLayoutManager(this, getResources().getInteger(R.integer.no_of_columns));

        /* Association of the LayoutManager with the RecyclerView */
        mRecyclerView.setLayoutManager(mLayoutManager);
        /*
         * Setting to improve performance when changes in content do not
         * change the child layout size in the RecyclerView
         */
        mRecyclerView.setHasFixedSize(true);

        if (savedInstanceState != null) {
            mItems = savedInstanceState.getParcelableArrayList(Config.BUNDLE_ART_OBJECTS);
            mSavedRecyclerLayoutState = savedInstanceState.getParcelable(Config.BUNDLE_RECYCLER_LAYOUT);
        }

        /*
         * Ensures a loader is initialized and active. If the loader doesn't already exist, one is
         * created and (if the activity/fragment is currently started) starts the loader. Otherwise
         * the last created loader is re-used.
         */
         getSupportLoaderManager().initLoader(ID_FAV_ITEMS_LOADER, null, this);

    }

/*

    private void showDataView() {
        /* First, make sure the error is invisible */
  /*      mErrorMessageDisplay.setVisibility(View.INVISIBLE);
        /* Then, make sure the movies are visible */
    /*    mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage() {
        /* First, hide the currently visible data */
      /*  mRecyclerView.setVisibility(View.INVISIBLE);
        mNoFavArtObjectsView.setVisibility(View.INVISIBLE);

        /* Then, show the error */
      /*  mErrorMessageDisplay.setVisibility(View.VISIBLE);

    }*/

    @Override
    public void onClick(ArtObject artObject) {

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Config.BUNDLE_ART_OBJECT_ID, artObject.getId());

        startActivity(intent);
    }

    /**
     * Called by the {@link android.support.v4.app.LoaderManagerImpl} when a new Loader needs to be
     * created. This Activity only uses one loader, so we don't necessarily NEED to check the
     * loaderId, but this is certainly best practice.
     *
     * @param id   The loader ID for which we need to create a loader
     * @param args Any arguments supplied by the caller
     * @return A new Loader instance that is ready to start loading.
     */
    //  @Override
    @NonNull
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
//         If the loader requested is our fav_items loader, return the appropriate CursorLoader
            case ID_FAV_ITEMS_LOADER:
                Uri uri = ArtObjectsContract.ArtObjectsEntry.CONTENT_URI;
                /* Sort order: Ascending by date */
//        String sortOrder = WeatherContract.WeatherEntry.COLUMN_DATE + " ASC";
                return new CursorLoader(this, uri, FAV_OBJECTS_PROJECTION, null, null,null);
            default:
                throw new RuntimeException("Loader Not Implemented: " + id);
        }
    }


    /**
     * Called when a Loader has finished loading its data.
     * <p>
     * NOTE: There is one small bug in this code. If no data is present in the cursor do to an
     * initial load being performed with no access to internet, the loading indicator will show
     * indefinitely, until data is present from the ContentProvider. This will be fixed in a
     * future version of the course.
     *
     * @param loader The Loader that has finished.
     */
    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        mFavItemsAdapter.setData(cursor);
        if (mPosition == RecyclerView.NO_POSITION) mPosition = 0;
        mRecyclerView.smoothScrollToPosition(mPosition);
        //   if (data.getCount() != 0) showWeatherDataView();
        /* Setting the adapter attaches it to the RecyclerView in our layout. */
        mRecyclerView.setAdapter(mFavItemsAdapter);
            }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        mFavItemsAdapter.swapCursor(null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home){
            finish();
        }

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
