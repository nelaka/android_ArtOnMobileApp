package com.example.android.android_artonmobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.android.android_artonmobileapp.model.StyleDetails;
import com.example.android.android_artonmobileapp.rest.ApiClient;
import com.example.android.android_artonmobileapp.rest.ApiInterface;
import com.example.android.android_artonmobileapp.utils.Config;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StyleActivity extends AppCompatActivity {
    @BindView(R.id.style_name)
    TextView mStyleName;
    private StyleDetails mStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String styleName;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        if (intent != null) {
            if (intent.hasExtra(Config.BUNDLE_STYLE)) {
                styleName = intent.getStringExtra(Config.BUNDLE_STYLE);

                styleRequest(styleName);
            }
        }
    }

    private void styleRequest(String styleName) {

        //     mLoadingIndicator.setVisibility(View.VISIBLE);

        if (mStyle == null) {

            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<StyleDetails> call = apiService.getStyleDetails(styleName, Config.rijksmuseumApiKey, "json");
            call.enqueue(new Callback<StyleDetails>() {

                @Override
                public void onResponse(@NonNull Call<StyleDetails> call, @NonNull Response<StyleDetails> response) {
                    mStyle = response.body();
                    Log.d("STYLE ACTIVITY ", "Number of results received: " + mStyle.getTitle());
                    //         mLoadingIndicator.setVisibility(View.INVISIBLE);
                    mStyleName.setText(mStyle.getTitle());

                }

                @Override
                public void onFailure(@NonNull Call<StyleDetails> call, @NonNull Throwable t) {

                    //  mLoadingIndicator.setVisibility(View.INVISIBLE);
                    // showErrorMessage();

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
            //showDataView();
        }
    }

}
