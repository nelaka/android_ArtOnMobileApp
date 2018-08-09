package com.example.android.android_artonmobileapp;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.example.android.android_artonmobileapp.holder.ArtObjectViewHolder;
import com.example.android.android_artonmobileapp.model.ArtObject;
import com.example.android.android_artonmobileapp.model.ArtObjectResponse;
import com.example.android.android_artonmobileapp.rest.ApiClient;
import com.example.android.android_artonmobileapp.rest.ApiInterface;
import com.example.android.android_artonmobileapp.utils.Config;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements ArtObjectViewHolder.ArtObjectAdapterOnClickHandler {

    @BindView(R.id.items_rv)
    RecyclerView mRecyclerView;
    @BindView(R.id.pb_loading_indicator)
    ProgressBar mLoadingIndicator;
    @BindView(R.id.tv_error_message_display)
    TextView mErrorMessageDisplay;
    private String mQuery, mSortBy;
    private ArrayList<ArtObject> mItems;
    private Context mContext;
    private ArtObjectsAdapter mArtObjectsAdapter;
    private Parcelable mSavedRecyclerLayoutState;
    private GridLayoutManager mLayoutManager;
    private OnFragmentInteractionListener mListener;
    private String mErrorMsg = null;
    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(Config.BUNDLE_ART_OBJECTS, mItems);
        outState.putParcelable(Config.BUNDLE_RECYCLER_LAYOUT, mRecyclerView.getLayoutManager().onSaveInstanceState());
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Config.BUNDLE_RECYCLER_LAYOUT)) {
                mItems = savedInstanceState.getParcelableArrayList(Config.BUNDLE_ART_OBJECTS);
                mSavedRecyclerLayoutState = savedInstanceState.getParcelable(Config.BUNDLE_RECYCLER_LAYOUT);
                mLayoutManager.onRestoreInstanceState(mSavedRecyclerLayoutState);
            }
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);

        mArtObjectsAdapter = new ArtObjectsAdapter(this, mContext);

        if (savedInstanceState != null) {
            mItems = savedInstanceState.getParcelableArrayList(Config.BUNDLE_ART_OBJECTS);
            mSavedRecyclerLayoutState = savedInstanceState.getParcelable(Config.BUNDLE_RECYCLER_LAYOUT);

        } else {
            Bundle bundle = getArguments();

            if (bundle != null) {
                if (bundle.containsKey(Config.BUNDLE_QUERY)) {
                    mQuery = getArguments().getString(Config.BUNDLE_QUERY);
                }
                if (bundle.containsKey(Config.BUNDLE_SORT_BY)) {
                    mSortBy = getArguments().getString(Config.BUNDLE_SORT_BY);
                }
            }

        }
        itemsRequest();
        return rootView;
    }

    private void itemsRequest() {

        mLoadingIndicator.setVisibility(View.VISIBLE);
        mLayoutManager = new GridLayoutManager(mContext, getResources().getInteger(R.integer.no_of_columns));
        /* Association of the LayoutManager with the RecyclerView */
        mRecyclerView.setLayoutManager(mLayoutManager);
        /*
         * Setting to improve performance when changes in content do not
         * change the child layout size in the RecyclerView
         */
        mRecyclerView.setHasFixedSize(true);

        if (mItems == null) {
            new RetrieveArtObjectsTask().execute();

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

    private void showErrorMessage(String msg) {
        /* First, hide the currently visible data */
        mRecyclerView.setVisibility(View.INVISIBLE);
        //mNoFavArtObjectsView.setVisibility(View.INVISIBLE);

        /* Then, show the error */
        mErrorMessageDisplay.setText(msg);
        mErrorMessageDisplay.setVisibility(View.VISIBLE);
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

    public class RetrieveArtObjectsTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            String API_KEY = Config.rijksmuseumApiKey;

            if (API_KEY.isEmpty()) {
                mErrorMsg = getResources().getString(R.string.msg_error_no_api_key);
                showErrorMessage(mErrorMsg);
                mLoadingIndicator.setVisibility(View.INVISIBLE);
                mErrorMessageDisplay.setVisibility(View.VISIBLE);
                return null;
            } else {


                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                Call<ArtObjectResponse> call;
                if (mQuery == null) {
                    call = apiService.getArtObjects(API_KEY, "json", Config.RESULTS_RETURNED, true, mSortBy);
                } else {
                    call = apiService.getPaintings(API_KEY, "json", Config.RESULTS_RETURNED, true, mQuery, mSortBy);
                }

                call.enqueue(new Callback<ArtObjectResponse>() {

                    @Override
                    public void onResponse(@NonNull Call<ArtObjectResponse> call, @NonNull Response<ArtObjectResponse> response) {
                        if (response.body() != null) {
                            mItems = response.body().getArtObjects();
                        }
                        Log.d("MAIN ", "Number of results received: " + mItems.size());
                        mLoadingIndicator.setVisibility(View.INVISIBLE);

                        if (mItems != null) {
                            mArtObjectsAdapter.setData(mItems);

                            /* Setting the adapter attaches it to the RecyclerView in our layout. */
                            mRecyclerView.setAdapter(mArtObjectsAdapter);
                            showDataView();

                        } else {
                            mErrorMsg = getResources().getString(R.string.msg_error);
                            showErrorMessage(mErrorMsg);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ArtObjectResponse> call, @NonNull Throwable t) {

                        mLoadingIndicator.setVisibility(View.INVISIBLE);
                        mErrorMsg = getResources().getString(R.string.msg_error);
                        showErrorMessage(mErrorMsg);
                        // Log error here since request failed
                        Log.e("main", t.toString());
                    }
                });
                return null;
            }
        }


    }

}