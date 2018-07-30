package com.example.android.android_artonmobileapp;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.android_artonmobileapp.adapter.FavItemsAdapter;
import com.example.android.android_artonmobileapp.data.ArtObjectsContract;
import com.example.android.android_artonmobileapp.holder.FavItemViewHolder;
import com.example.android.android_artonmobileapp.model.ArtObject;
import com.example.android.android_artonmobileapp.utils.Config;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.android.android_artonmobileapp.utils.Config.ID_FAV_ITEMS_LOADER;

public class FavActivity extends AppCompatActivity implements FavItemViewHolder.FavItemsAdapterOnClickHandler {
    @BindView(R.id.items1_rv)
    RecyclerView mRecyclerView;
    private List<ArtObject> mItems;
    /*   @BindView(R.id.pb_loading_indicator)
       ProgressBar mLoadingIndicator;
       @BindView(R.id.tv_error_message_display)
       TextView mErrorMessageDisplay;
       @BindView(R.id.tv_no_fav_art_objects)
       TextView mNoFavArtObjectsView;
      */ private String mQuery;
    private int mPosition = RecyclerView.NO_POSITION;
    private FavItemsAdapter mFavItemsAdapter;
    private Parcelable mSavedRecyclerLayoutState;
    private GridLayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        mFavItemsAdapter = new FavItemsAdapter(this, this);
        mLayoutManager = new GridLayoutManager(this, getResources().getInteger(R.integer.no_of_columns));

        /* Association of the LayoutManager with the RecyclerView */
        mRecyclerView.setLayoutManager(mLayoutManager);
        /*
         * Setting to improve performance when changes in content do not
         * change the child layout size in the RecyclerView
         */
        mRecyclerView.setHasFixedSize(true);


  /*     Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(BUNDLE_FAVORITES)) {
                artObjectsFromDB();
            }
        }
*/
        if (savedInstanceState != null) {
            mItems = savedInstanceState.getParcelableArrayList(Config.BUNDLE_ART_OBJECTS);
            mSavedRecyclerLayoutState = savedInstanceState.getParcelable(Config.BUNDLE_RECYCLER_LAYOUT);
        } else {
            artObjectsFromDB();

        }

        /*
         * Ensures a loader is initialized and active. If the loader doesn't already exist, one is
         * created and (if the activity/fragment is currently started) starts the loader. Otherwise
         * the last created loader is re-used.
         */
        // getSupportLoaderManager().initLoader(ID_FAV_ITEMS_LOADER, null, this);

    }

    private void artObjectsFromDB() {
        Uri uri = ArtObjectsContract.ArtObjectsEntry.CONTENT_URI;
        /* Sort order: Ascending by date */
//        String sortOrder = WeatherContract.WeatherEntry.COLUMN_DATE + " ASC";

        ContentResolver resolver = getContentResolver();
        Cursor itemsResponse = resolver.query(uri, null, null, null, null);

        if (itemsResponse.getCount() <= 0) {
            //showNoFavMovieMessage();
            return;
        }


        /* Setting the adapter attaches it to the RecyclerView in our layout. */
        mFavItemsAdapter.setData(mItems);

        /* Setting the adapter attaches it to the RecyclerView in our layout. */
        mRecyclerView.setAdapter(mFavItemsAdapter);
        //showMovieDataView();
        itemsResponse.close();


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
    //  @Override
    public Loader<List<ArtObject>> onCreateLoader(int id, Bundle args) {
        switch (id) {

//         If the loader requested is our fav_items loader, return the appropriate CursorLoader
            case ID_FAV_ITEMS_LOADER:

                artObjectsFromDB();

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
     * @param data   The data generated by the Loader.
     */
    //@Override
    public void onLoadFinished(@NonNull Loader<List<ArtObject>> loader, List<ArtObject> data) {
        mFavItemsAdapter.setData(data);
        if (mPosition == RecyclerView.NO_POSITION) mPosition = 0;
        mRecyclerView.smoothScrollToPosition(mPosition);


        //   if (data.getCount() != 0) showWeatherDataView();
    }

    /**
     * Called when a previously created loader is being reset, and thus making its data unavailable.
     * The application should at this point remove any references it has to the Loader's data.
     *
     * @param loader The Loader that is being reset.
     */
    //@Override
    public void onLoaderReset(@NonNull Loader<List<ArtObject>> loader) {
        /*
         * Since this Loader's data is now invalid, we need to clear the Adapter that is
         * displaying the data.
         */
        mFavItemsAdapter.swapCursor(null);
    }


}
