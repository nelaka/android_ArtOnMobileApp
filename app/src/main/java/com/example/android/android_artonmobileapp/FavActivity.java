/**Copyright 2018 Eleni Kalkopoulou

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 * */
package com.example.android.android_artonmobileapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.android.android_artonmobileapp.adapter.FavItemsAdapter;
import com.example.android.android_artonmobileapp.database.AppDatabase;
import com.example.android.android_artonmobileapp.database.FavArtObjectEntry;
import com.example.android.android_artonmobileapp.holder.FavItemViewHolder;
import com.example.android.android_artonmobileapp.model.ArtObject;
import com.example.android.android_artonmobileapp.utils.Config;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FavActivity extends AppCompatActivity implements FavItemViewHolder.FavItemsAdapterOnClickHandler {

    private static final String TAG = FavActivity.class.getSimpleName();

    @BindView(R.id.fav_items_rv)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_error_message_display)
    TextView mErrorMessageDisplay;

    private FavItemsAdapter mFavItemsAdapter;
    private GridLayoutManager mLayoutManager;

    private void setupViewModel(){

       FavViewModel viewModel = ViewModelProviders.of(this).get(FavViewModel.class);
       //Observe the LiveData object in the ViewModel
       viewModel.getFavArtObjects().observe(this, new Observer<List<FavArtObjectEntry>>() {
            @Override
            public void onChanged(@Nullable List<FavArtObjectEntry> favArtObjectEntries) {
                Log.d(TAG, "Updating list of tasks from LiveData in ViewModel");
                if (favArtObjectEntries.size() <= 0) showErrorMessage(getString(R.string.msg_no_fav_items));
                mFavItemsAdapter.setData(favArtObjectEntries);
            }
        });
    }

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

        // Attach the adapter to the RecyclerView
        mRecyclerView.setAdapter(mFavItemsAdapter);

        setupViewModel();

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