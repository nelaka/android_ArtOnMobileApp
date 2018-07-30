package com.example.android.android_artonmobileapp;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.android_artonmobileapp.adapter.ArtObjectsAdapter;
import com.example.android.android_artonmobileapp.adapter.FavItemsAdapter;
import com.example.android.android_artonmobileapp.data.ArtObjectsContract;
import com.example.android.android_artonmobileapp.holder.ArtObjectViewHolder;
import com.example.android.android_artonmobileapp.model.ArtObject;
import com.example.android.android_artonmobileapp.model.ArtObjectResponse;
import com.example.android.android_artonmobileapp.rest.ApiClient;
import com.example.android.android_artonmobileapp.rest.ApiInterface;
import com.example.android.android_artonmobileapp.utils.Config;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;
import static com.example.android.android_artonmobileapp.data.ArtObjectsContract.ArtObjectsEntry.COLUMN_ART_OBJECT_ID;
import static com.example.android.android_artonmobileapp.data.ArtObjectsContract.ArtObjectsEntry.COLUMN_IMAGE;
import static com.example.android.android_artonmobileapp.data.ArtObjectsContract.ArtObjectsEntry.COLUMN_MAKER;
import static com.example.android.android_artonmobileapp.data.ArtObjectsContract.ArtObjectsEntry.COLUMN_TITLE;
import static com.example.android.android_artonmobileapp.data.ArtObjectsContract.ArtObjectsEntry.COLUMN_TITLE_LONG;
import static com.example.android.android_artonmobileapp.utils.Config.BUNDLE_FAVORITES;
import static com.example.android.android_artonmobileapp.utils.Config.CHANGES_IN_FAV_ITEMS;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements ArtObjectViewHolder.ArtObjectAdapterOnClickHandler{

        private String mQuery;
        private List<ArtObject> mItems;

        @BindView(R.id.items_rv)
        RecyclerView mRecyclerView;
        @BindView(R.id.pb_loading_indicator)
        ProgressBar mLoadingIndicator;
        @BindView(R.id.tv_error_message_display)
        TextView mErrorMessageDisplay;
        @BindView(R.id.tv_no_fav_art_objects)
        TextView mNoFavArtObjectsView;

        private Context mContext;
        private ArtObjectsAdapter mArtObjectsAdapter;
    private FavItemsAdapter mFavItemsAdapter;
        private Parcelable mSavedRecyclerLayoutState;
        private GridLayoutManager mLayoutManager;
        private OnFragmentInteractionListener mListener;


        public MainFragment() {
            // Required empty public constructor
        }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);

        mArtObjectsAdapter = new ArtObjectsAdapter(this, mContext);
        mLayoutManager = new GridLayoutManager(mContext, getResources().getInteger(R.integer.no_of_columns));

        /* Association of the LayoutManager with the RecyclerView */
        mRecyclerView.setLayoutManager(mLayoutManager);
        /*
         * Setting to improve performance when changes in content do not
         * change the child layout size in the RecyclerView
         */
        mRecyclerView.setHasFixedSize(true);


        Intent intent = getActivity().getIntent();
        if (intent != null) {
            if (intent.hasExtra(Config.BUNDLE_STYLE)) {
                mQuery = intent.getStringExtra(Config.BUNDLE_STYLE);
            } else if (intent.hasExtra(Config.BUNDLE_QUERY)) {
                mQuery = intent.getStringExtra(Config.BUNDLE_QUERY);
            } else if (intent.hasExtra(BUNDLE_FAVORITES)) {
                artObjectsFromDB();
            }

        }


        if (savedInstanceState != null) {
            mItems = savedInstanceState.getParcelableArrayList(Config.BUNDLE_ART_OBJECTS);
            mSavedRecyclerLayoutState = savedInstanceState.getParcelable(Config.BUNDLE_RECYCLER_LAYOUT);
        }
        else {
            itemsRequest();

        }
        return rootView;
    }

    private void itemsRequest() {

        mLoadingIndicator.setVisibility(View.VISIBLE);

        if (mItems == null) {

            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<ArtObjectResponse> call;
            if (mQuery == null) {
                call = apiService.getArtObjects(Config.rijksmuseumApiKey, "json", 30, true);
            } else {
                call = apiService.getPaintings(Config.rijksmuseumApiKey, "json", 30, true, mQuery);
            }

            call.enqueue(new Callback<ArtObjectResponse>() {

                @Override
                public void onResponse(@NonNull Call<ArtObjectResponse> call, @NonNull Response<ArtObjectResponse> response) {
                    mItems = response.body().getArtObjects();
                    Log.d("MAIN ", "Number of results received: " + mItems.size());
                    mLoadingIndicator.setVisibility(View.INVISIBLE);


                    if (mItems != null) {

                        mArtObjectsAdapter.setData(mItems);

                        /* Setting the adapter attaches it to the RecyclerView in our layout. */
                        mRecyclerView.setAdapter(mArtObjectsAdapter);
                        showDataView();

                    } else {
                        showErrorMessage();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ArtObjectResponse> call, @NonNull Throwable t) {

                    mLoadingIndicator.setVisibility(View.INVISIBLE);
                    showErrorMessage();

                    // Log error here since request failed
                    Log.e("main", t.toString());
                }
            });
        } else {
            mLoadingIndicator.setVisibility(View.INVISIBLE);
            mArtObjectsAdapter.setData(mItems);

            /* Setting the adapter attaches it to the RecyclerView in the layout. */
            mRecyclerView.getLayoutManager().onRestoreInstanceState(mSavedRecyclerLayoutState);

            mRecyclerView.setAdapter(mArtObjectsAdapter);
            showDataView();
        }
    }

    private void showDataView() {
        /* First, make sure the error is invisible */
        mErrorMessageDisplay.setVisibility(View.INVISIBLE);
        /* Then, make sure the movies are visible */
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage() {
        /* First, hide the currently visible data */
        mRecyclerView.setVisibility(View.INVISIBLE);
        mNoFavArtObjectsView.setVisibility(View.INVISIBLE);

        /* Then, show the error */
        mErrorMessageDisplay.setVisibility(View.VISIBLE);

    }

    private void artObjectsFromDB() {
        Uri uri = ArtObjectsContract.ArtObjectsEntry.CONTENT_URI;
        ContentResolver resolver = getActivity().getContentResolver();
        Cursor itemsResponse = resolver.query(uri, null, null, null, null);

        if (itemsResponse.getCount() <= 0) {
            //showNoFavMovieMessage();
            return;
        }
        // Create an empty ArrayList that we can start adding movies to
        ArrayList<ArtObject> items = new ArrayList<>();

        for (int i = 0; i < itemsResponse.getCount(); i++) {
            int itemIdIndex = itemsResponse.getColumnIndex(COLUMN_ART_OBJECT_ID);
            int itemTitleIndex = itemsResponse.getColumnIndex(COLUMN_TITLE);
            int itemMakerIndex = itemsResponse.getColumnIndex(COLUMN_MAKER);
            int itemTitleLongIndex = itemsResponse.getColumnIndex(COLUMN_TITLE_LONG);
            int itemImageIndex = itemsResponse.getColumnIndex(COLUMN_IMAGE);

            itemsResponse.moveToPosition(i);

            items.add(new ArtObject(itemsResponse.getString(itemIdIndex), itemsResponse.getString(itemTitleIndex), itemsResponse.getString(itemMakerIndex), itemsResponse.getString(itemTitleLongIndex), itemsResponse.getString(itemImageIndex)));
        }
        /* Setting the adapter attaches it to the RecyclerView in our layout. */
        mFavItemsAdapter.setData(mItems);

        /* Setting the adapter attaches it to the RecyclerView in our layout. */
        mRecyclerView.setAdapter(mFavItemsAdapter);
        //showMovieDataView();
        itemsResponse.close();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check which request we're responding to
        if (requestCode == CHANGES_IN_FAV_ITEMS) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                mSavedRecyclerLayoutState = mRecyclerView.getLayoutManager().onSaveInstanceState();
                itemsRequest();
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(ArtObject artObject) {
        mListener.onFragmentInteraction(artObject);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(ArtObject artObject);
    }
}
