package com.example.android.android_artonmobileapp;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.android_artonmobileapp.adapter.FavItemsAdapter;
import com.example.android.android_artonmobileapp.data.ArtObjectsContract;
import com.example.android.android_artonmobileapp.holder.FavItemViewHolder;
import com.example.android.android_artonmobileapp.model.ArtObject;
import com.example.android.android_artonmobileapp.utils.Config;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.android.android_artonmobileapp.adapter.FavItemsAdapter.FAV_OBJECTS_PROJECTION;
import static com.example.android.android_artonmobileapp.utils.Config.ID_FAV_ITEMS_LOADER;

public class FavActivity extends AppCompatActivity implements FavItemViewHolder.FavItemsAdapterOnClickHandler, LoaderManager.LoaderCallbacks<Cursor> {
    @BindView(R.id.fav_items_rv)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_error_message_display)
    TextView mErrorMessageDisplay;

    private ArrayList<ArtObject> mItems;
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
        if (getSupportActionBar() != null) {
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(Config.BUNDLE_ART_OBJECTS, mItems);
        outState.putParcelable(Config.BUNDLE_RECYCLER_LAYOUT, mRecyclerView.getLayoutManager().onSaveInstanceState());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Config.BUNDLE_RECYCLER_LAYOUT)) {
                mItems = savedInstanceState.getParcelableArrayList(Config.BUNDLE_ART_OBJECTS);
                mSavedRecyclerLayoutState = savedInstanceState.getParcelable(Config.BUNDLE_RECYCLER_LAYOUT);
                mLayoutManager.onRestoreInstanceState(mSavedRecyclerLayoutState);
            }
        }
    }

    private void showErrorMessage(String msg) {
        /* First, hide the currently visible data */
        mRecyclerView.setVisibility(View.INVISIBLE);
        /* Then, show the error */
        mErrorMessageDisplay.setText(msg);
        mErrorMessageDisplay.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(ArtObject artObject) {
        Intent intent = new Intent(this, DetailActivity.class);
        //For the detail fragment
        intent.putExtra(Config.BUNDLE_ART_OBJECT_ID, artObject.getId());
        //For the detail activity (share intent)
        intent.putExtra(Config.BUNDLE_ART_OBJECT, artObject);
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
    @NonNull
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            //If the loader requested is our fav_items loader, return the appropriate CursorLoader
            case ID_FAV_ITEMS_LOADER:
                Uri uri = ArtObjectsContract.ArtObjectsEntry.CONTENT_URI;
                return new CursorLoader(this, uri, FAV_OBJECTS_PROJECTION, null, null, null);
            default:
                throw new RuntimeException("Loader Not Implemented: " + id);
        }
    }

    /**
     * Called when a Loader has finished loading its data.
     *
     * @param loader The Loader that has finished.
     */
    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        if (cursor.getCount() > 0) {
            mFavItemsAdapter.swapCursor(cursor);
            if (mPosition == RecyclerView.NO_POSITION) mPosition = 0;
            mRecyclerView.smoothScrollToPosition(mPosition);
            /* Setting the adapter attaches it to the RecyclerView in our layout. */
            mRecyclerView.setAdapter(mFavItemsAdapter);
        } else {
            showErrorMessage(getString(R.string.msg_no_fav_items));
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        mFavItemsAdapter.swapCursor(null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}