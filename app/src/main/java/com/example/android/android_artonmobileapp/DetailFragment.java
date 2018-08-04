package com.example.android.android_artonmobileapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.android_artonmobileapp.data.ArtObjectsContract;
import com.example.android.android_artonmobileapp.data.ArtObjectsContract.ArtObjectsEntry;
import com.example.android.android_artonmobileapp.model.ArtObjectDetail;
import com.example.android.android_artonmobileapp.model.ArtObjectDetailResponse;
import com.example.android.android_artonmobileapp.rest.ApiClient;
import com.example.android.android_artonmobileapp.rest.ApiInterface;
import com.example.android.android_artonmobileapp.utils.Config;
import com.example.android.android_artonmobileapp.utils.Utils;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailFragment}.
 * */
public class DetailFragment extends Fragment {
    ArtObjectDetail mDetails;
    private String mTitle;
    @BindView(R.id.art_object_iv)
    ImageView mArtObjectView;
    @BindView(R.id.art_object_desc_tv)
    TextView mArtObjectDescView;
    @BindView(R.id.art_object_maker_tv)
    TextView mArtObjectMakerView;
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
    Boolean mFavorite = false;
    private String mId;
 private Context mContext;


    public DetailFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, rootView);

        Intent intent = getActivity().getIntent();

        if (intent != null) {
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

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<ArtObjectDetailResponse> call = apiService.getArtObjectDetails(id, Config.rijksmuseumApiKey, "json");
        call.enqueue(new Callback<ArtObjectDetailResponse>() {

            @Override
            public void onResponse(@NonNull Call<ArtObjectDetailResponse> call, @NonNull Response<ArtObjectDetailResponse> response) {
                if ((response.body())!= null) {
                    mDetails = response.body().getArtObject();

                    mTitle = response.body().getArtObject().getTitle();

                    // Display the current selected movie title on the Action Bar
                    //      getSupportActionBar()
                    mToolbar.setTitle(mTitle);
                    //    Log.v("adapterART OBJECT", "url = " + mUrl);

                    Picasso.get().load(mDetails.getWebImage().getUrl()).placeholder(R.drawable.placeholder1200).error(R.drawable.placeholder1200).into(mArtObjectView);

                    mArtObjectDescView.setText(mDetails.getPlaqueDescriptionEnglish());
                      mArtObjectMakerView.setText(mDetails.getPrincipalOrFirstMaker());
                       int intColorValue = Color.parseColor(mDetails.getNormalizedColors().get(0));
  //                  Log.d(TAG, "COlor is : " + mDetails.getNormalizedColors().get(0));
    //                Log.d(TAG, "COlor is : " + Math.abs(intColorValue));

                    //mArtObjectColor1.setBackgroundColor(Math.abs(intColorValue));
        /*     intColorValue = Color.parseColor(mDetails.getNormalizedColors().get(1));
                    Log.d(TAG, "COlor is : " + mDetails.getNormalizedColors().get(1));
                    mArtObjectColor2.setBackgroundColor(intColorValue);
                    intColorValue = Color.parseColor(mDetails.getNormalizedColors().get(2));
                    Log.d(TAG, "COlor is : " + mDetails.getNormalizedColors().get(2));
                    mArtObjectColor3.setBackgroundColor(Math.abs(intColorValue));
                    intColorValue = Color.parseColor(mDetails.getNormalizedColors().get(3));
                    mArtObjectColor4.setBackgroundColor(Math.abs(intColorValue));
                    intColorValue = Color.parseColor(mDetails.getNormalizedColors().get(4));
                    mArtObjectColor5.setBackgroundColor(Math.abs(intColorValue));
                    intColorValue = Color.parseColor(mDetails.getNormalizedColors().get(5));
                    mArtObjectColor6.setBackgroundColor(Math.abs(intColorValue));
*/

                }
                Log.d("DETAIL ", "Number of colors results received: " + mDetails.getTitle());
                mLoadingIndicator.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(@NonNull Call<ArtObjectDetailResponse> call, @NonNull Throwable t) {
                // Log error here since request failed
                Log.e("detail", t.toString());
            }
        });
    }

    private boolean isFavorite(String id) {
        boolean isFavorite;
        String[] favoriteId = new String[]{String.valueOf(id)};
        Cursor cursor = getActivity().getContentResolver().query(ArtObjectsContract.ArtObjectsEntry.CONTENT_URI, null, "id=?", favoriteId, null);

        if (cursor.getCount() > 0) {
            isFavorite = true;
            fab.setImageResource(R.drawable.ic_favorite_white_24dp);
        } else {
            isFavorite = false;
            fab.setImageResource(R.drawable.ic_favorite_border_white_24dp);
        }

        cursor.close();
        return isFavorite;
    }

    private void removeItemFromFavorites(String id) {
        Uri uri = ArtObjectsEntry.CONTENT_URI;
        uri = uri.buildUpon().appendPath(String.valueOf(id)).build();

        int rowsDeleted = getContext().getContentResolver().delete(uri, null, null);

        // [Hint] Don't forget to call finish() to return to MainActivity after this insert is complete
        Log.d(TAG, "rowsDeleted =" + rowsDeleted + " " + uri + " " + String.valueOf(id));
        if (rowsDeleted > 0) {

            Utils.mySnackBar(getView(), R.string.msg_removed_from_fav);
            getContext().getContentResolver().notifyChange(uri, null);
            mFavorite = false;
            getActivity().setResult(RESULT_OK);
        }
    }

    private void addItemToFavorites(String id) {
        // Create new empty ContentValues object
        ContentValues contentValues = new ContentValues();
        // Put the task description and selected mPriority into the ContentValues
        contentValues.put(ArtObjectsEntry.COLUMN_ART_OBJECT_ID, id);
        contentValues.put(ArtObjectsEntry.COLUMN_TITLE, mDetails.getTitle());
        contentValues.put(ArtObjectsEntry.COLUMN_MAKER, mDetails.getPrincipalOrFirstMaker());
        contentValues.put(ArtObjectsEntry.COLUMN_IMAGE, mDetails.getWebImage().getUrl());

        // Insert the content values via a ContentResolver
        Uri uri = getContext().getContentResolver().insert(ArtObjectsEntry.CONTENT_URI, contentValues);
        Log.d(TAG, "Uri =" + uri + " " + String.valueOf(id));

        if (uri != null) {
            Utils.mySnackBar(getView(), R.string.msg_added_to_fav);
            mFavorite = true;
        }
    }
}