package com.example.android.android_artonmobileapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.android_artonmobileapp.adapter.StylesAdapter;
import com.example.android.android_artonmobileapp.holder.StyleViewHolder;
import com.example.android.android_artonmobileapp.model.Style;
import com.example.android.android_artonmobileapp.model.StylesResponse;
import com.example.android.android_artonmobileapp.rest.ApiClient;
import com.example.android.android_artonmobileapp.rest.ApiInterface;
import com.example.android.android_artonmobileapp.utils.Config;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StylesActivity extends AppCompatActivity implements StyleViewHolder.StylesAdapterOnClickHandler {
    @BindView(R.id.styles_rv)
    RecyclerView mRecyclerView;
    private List<Style> mStyles;
    private Context mContext;
    private StylesAdapter mStylesAdapter;
    private Parcelable mSavedRecyclerLayoutState;

    private GridLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styles);

        ButterKnife.bind(this);

        mStylesAdapter = new StylesAdapter(this, this);
        mLayoutManager = new GridLayoutManager(mContext, getResources().getInteger(R.integer.no_of_columns_styles));
        /* Association of the LayoutManager with the RecyclerView */
        mRecyclerView.setLayoutManager(mLayoutManager);
        /*
         * Setting to improve performance when changes in content do not
         * change the child layout size in the RecyclerView
         */
        mRecyclerView.setHasFixedSize(true);

        if (savedInstanceState != null) {
            //   mArtists = savedInstanceState.getParcelableArrayList(Config.BUNDLE_ART_OBJECTS);
            //      mSavedRecyclerLayoutState = savedInstanceState.getParcelable(Config.BUNDLE_RECYCLER_LAYOUT);
        } else {
            //itemsRequest();
            stylesRequest();
        }
    }

    private void stylesRequest() {

        //     mLoadingIndicator.setVisibility(View.VISIBLE);

        if (mStyles == null) {

            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<StylesResponse> call = apiService.getStyles(Config.rijksmuseumApiKey, "json");
            call.enqueue(new Callback<StylesResponse>() {

                @Override
                public void onResponse(@NonNull Call<StylesResponse> call, @NonNull Response<StylesResponse> response) {
                    mStyles = response.body().getContentPage().getCategoryItems();
                    Log.d("MAIN ", "Number of results received: " + mStyles.get(0).getTitle());
                    //         mLoadingIndicator.setVisibility(View.INVISIBLE);

                    if (mStyles != null) {

                        mStylesAdapter.setData(mStyles);

                        /* Setting the adapter attaches it to the RecyclerView in our layout. */
                        mRecyclerView.setAdapter(mStylesAdapter);
                        showDataView();

                    } else {
                        showErrorMessage();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<StylesResponse> call, @NonNull Throwable t) {

                    //  mLoadingIndicator.setVisibility(View.INVISIBLE);
                    showErrorMessage();

                    // Log error here since request failed
                    Log.e("main", t.toString());
                }
            });
        } else {
            //      mLoadingIndicator.setVisibility(View.INVISIBLE);
            //   mArtistsAdapter.setData(mArtists);

            /* Setting the adapter attaches it to the RecyclerView in the layout. */
            //     mRecyclerView.getLayoutManager().onRestoreInstanceState(mSavedRecyclerLayoutState);

            //   mRecyclerView.setAdapter(mArtistsAdapter);
            showDataView();
        }
    }


    private void showDataView() {
        /* First, make sure the error is invisible */
        //     mErrorMessageDisplay.setVisibility(View.INVISIBLE);
        /* Then, make sure the movies are visible */
        //       mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage() {
        /* First, hide the currently visible data */
        //         mRecyclerView.setVisibility(View.INVISIBLE);
        //       mNoFavArtObjectsView.setVisibility(View.INVISIBLE);

        /* Then, show the error */
        //   mErrorMessageDisplay.setVisibility(View.VISIBLE);

    }


    @Override
    public void onClick(Style style) {
        Intent intent = new Intent(this, StyleActivity.class);
        intent.putExtra(Config.BUNDLE_STYLE, style.getTitle());
        startActivity(intent);
    }
}
