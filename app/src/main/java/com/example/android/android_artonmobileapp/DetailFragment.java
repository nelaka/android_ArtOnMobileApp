/**
 * Copyright 2018 Eleni Kalkopoulou
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.android_artonmobileapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.android_artonmobileapp.database.AppDatabase;
import com.example.android.android_artonmobileapp.database.AppExecutors;
import com.example.android.android_artonmobileapp.database.FavArtObjectEntry;
import com.example.android.android_artonmobileapp.model.ArtObjectDetail;
import com.example.android.android_artonmobileapp.model.ArtObjectDetailResponse;
import com.example.android.android_artonmobileapp.rest.ApiClient;
import com.example.android.android_artonmobileapp.rest.ApiInterface;
import com.example.android.android_artonmobileapp.utils.Config;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailFragment}.
 */
public class DetailFragment extends Fragment {
    @BindView(R.id.title_long)
    TextView mArtObjectTitleLongView;
    @BindView(R.id.art_object_iv)
    ImageView mArtObjectView;
    @BindView(R.id.art_object_desc_tv)
    TextView mArtObjectDescView;
    @BindView(R.id.art_object_maker_tv)
    TextView mArtObjectMakerView;
    @BindView(R.id.label_desc)
    TextView mDescriptionLabel;
    @BindView(R.id.label_artist)
    TextView mArtistLabel;
    @BindView(R.id.color1)
    Button mArtObjectColor1;
    @BindView(R.id.color2)
    Button mArtObjectColor2;
    @BindView(R.id.color3)
    Button mArtObjectColor3;
    @BindView(R.id.color4)
    Button mArtObjectColor4;
    @BindView(R.id.color5)
    Button mArtObjectColor5;
    @BindView(R.id.color6)
    Button mArtObjectColor6;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.pb_loading_indicator)
    ProgressBar mLoadingIndicator;
    @BindView(R.id.tv_error_message_display)
    TextView mErrorMessageDisplay;

    private ArtObjectDetail mDetails;
    private Boolean mFavorite = false;
    private String mId;
    private String mErrorMsg = null;
    private AppDatabase mDb;
    private Context mContext;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(Config.BUNDLE_ART_OBJECT, mDetails);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Config.BUNDLE_ART_OBJECT)) {
                mDetails = savedInstanceState.getParcelable(Config.BUNDLE_ART_OBJECT);
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mDb = AppDatabase.getInstance(mContext);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, rootView);


        if (savedInstanceState != null && savedInstanceState.containsKey(Config.BUNDLE_ART_OBJECT)) {
            mDetails = savedInstanceState.getParcelable(Config.BUNDLE_ART_OBJECT);
        }

        if (getActivity().getIntent() != null) {
            Intent intent = getActivity().getIntent();
            if (intent.hasExtra(Config.BUNDLE_ART_OBJECT_ID)) {
                mId = intent.getStringExtra(Config.BUNDLE_ART_OBJECT_ID);
                artObjectDetailsRequest(mId);
            }
        }

        mFavorite = isFavorite(mId);

        // Setup FAB to open EditorActivity
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFavorite) {
                    fab.setImageResource(R.drawable.ic_favorite_border_white_24dp);
                    removeItemFromFavorites(mId);
                } else {
                    fab.setImageResource(R.drawable.ic_favorite_white_24dp);
                    addItemToFavorites(mId);
                }
            }
        });
        return rootView;
    }

    private void artObjectDetailsRequest(String id) {
        if (mDetails == null) {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            Call<ArtObjectDetailResponse> call = apiService.getArtObjectDetails(id, Config.rijksmuseumApiKey, "json");
            call.enqueue(new Callback<ArtObjectDetailResponse>() {

                @Override
                public void onResponse(@NonNull Call<ArtObjectDetailResponse> call, @NonNull Response<ArtObjectDetailResponse> response) {
                    if ((response.body()) != null) {
                        mDetails = response.body().getArtObject();
                        setUpView();
                    }
                    mLoadingIndicator.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onFailure(@NonNull Call<ArtObjectDetailResponse> call, @NonNull Throwable t) {
                    mLoadingIndicator.setVisibility(View.INVISIBLE);
                    mErrorMsg = getString(R.string.msg_error);
                    showErrorMessage(mErrorMsg);
                    // Log error here since request failed
                    Log.e("detail", t.toString());
                }
            });
        } else {
            setUpView();
        }
    }

    private void showErrorMessage(String msg) {
        /* Then, show the error */
        mErrorMessageDisplay.setText(msg);
        mErrorMessageDisplay.setVisibility(View.VISIBLE);
    }

    private void setUpView() {

        // Display the current selected movie title on the Action Bar
        mToolbar.setTitle(mDetails.getTitle());
        //mToolbar.setTitleTextColor(Color.WHITE);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        // add back arrow to toolbar
        if (((AppCompatActivity) getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Picasso.get().load(mDetails.getWebImage().getUrl()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(mArtObjectView);
        mArtObjectTitleLongView.setText(mDetails.getLongTitle());
        if (mDetails.getPlaqueDescriptionEnglish() != null) {
            mDescriptionLabel.setVisibility(View.VISIBLE);
        } else {
            mDescriptionLabel.setVisibility(View.INVISIBLE);
        }
        mArtObjectDescView.setText(mDetails.getPlaqueDescriptionEnglish());
        mArtObjectMakerView.setText(mDetails.getPrincipalOrFirstMaker());
        if (mDetails.getPrincipalOrFirstMaker() != null) {
            mArtistLabel.setVisibility(View.VISIBLE);
        } else {
            mArtistLabel.setVisibility(View.INVISIBLE);
        }
        int size = mDetails.getNormalizedColors().size();
        int intColorValue;
        switch (size) {
            case 6:
                intColorValue = Color.parseColor(mDetails.getNormalizedColors().get(5).replaceAll(" ", ""));
                mArtObjectColor6.setBackgroundColor(intColorValue);
                mArtObjectColor6.setVisibility(View.VISIBLE);
            case 5:
                intColorValue = Color.parseColor(mDetails.getNormalizedColors().get(4).replaceAll(" ", ""));
                mArtObjectColor5.setBackgroundColor(intColorValue);
                mArtObjectColor5.setVisibility(View.VISIBLE);
            case 4:
                intColorValue = Color.parseColor(mDetails.getNormalizedColors().get(3).replaceAll(" ", ""));
                mArtObjectColor4.setBackgroundColor(intColorValue);
                mArtObjectColor4.setVisibility(View.VISIBLE);
            case 3:
                intColorValue = Color.parseColor(mDetails.getNormalizedColors().get(2).replaceAll(" ", ""));
                mArtObjectColor3.setBackgroundColor(intColorValue);
                mArtObjectColor3.setVisibility(View.VISIBLE);
            case 2:
                intColorValue = Color.parseColor(mDetails.getNormalizedColors().get(1).replaceAll(" ", ""));
                mArtObjectColor2.setBackgroundColor(intColorValue);
                mArtObjectColor2.setVisibility(View.VISIBLE);
            case 1:
                intColorValue = Color.parseColor(mDetails.getNormalizedColors().get(0).replaceAll(" ", ""));
                mArtObjectColor1.setBackgroundColor(intColorValue);
                mArtObjectColor1.setVisibility(View.VISIBLE);
        }
    }

    private boolean isFavorite(String id) {
        final LiveData<FavArtObjectEntry> favArtObject = mDb.favArtObjectDao().loadFavArtObjectById(id);

        favArtObject.observe(this, new Observer<FavArtObjectEntry>() {
            @Override
            public void onChanged(@Nullable FavArtObjectEntry favArtObjectEntry) {
                if (favArtObject.getValue() != null) {
                    mFavorite = true;
                    fab.setImageResource(R.drawable.ic_favorite_white_24dp);
                } else {
                    mFavorite = false;
                    fab.setImageResource(R.drawable.ic_favorite_border_white_24dp);

                }
            }
        });

        return mFavorite;
    }

    private void removeItemFromFavorites(final String id) {
        final LiveData<FavArtObjectEntry> favArtObject = mDb.favArtObjectDao().loadFavArtObjectById(id);

        favArtObject.observe(this, new Observer<FavArtObjectEntry>() {
            @Override
            public void onChanged(@Nullable final FavArtObjectEntry favArtObjectEntry) {
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                mDb.favArtObjectDao().deleteTask(favArtObjectEntry);
                    }
                });
                favArtObject.removeObserver(this);
            }
        });

        mFavorite = false;
     }

    private void addItemToFavorites(String id) {
        final FavArtObjectEntry favArtObjectEntry = new FavArtObjectEntry(id, mDetails.getTitle(), mDetails.getPrincipalOrFirstMaker(), mDetails.getWebImage().getUrl(), mDetails.getPlaqueDescriptionEnglish());
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDb.favArtObjectDao().insertFavArtObject(favArtObjectEntry);
            }
        });
        mFavorite = true;
    }
}