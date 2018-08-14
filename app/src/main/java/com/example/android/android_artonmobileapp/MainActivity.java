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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.android.android_artonmobileapp.model.ArtObject;
import com.example.android.android_artonmobileapp.utils.Config;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private ActionBarDrawerToggle mToggle;
    @BindView(R.id.fab_mail)
    FloatingActionButton mFab;
    private Tracker mTracker;
    private Boolean mAllArtObjects = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getResources().getString(R.string.fab_email_text), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                composeEmail(null, getResources().getString(R.string.email_title));
            }
        });

        // Obtain the shared Tracker instance.
        AnalyticsApp application = (AnalyticsApp) getApplication();
        mTracker = application.getDefaultTracker();

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i(TAG, "Setting screen name: " + TAG);
        mTracker.setScreenName("Image~" + TAG);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_allworksofarts) {
            allArtObjects(null);
        } else if (id == R.id.nav_allpaintings) {
            /**
             * [START analytics custom_event]
             */
            mTracker.send(new HitBuilders.EventBuilder().setCategory("Action").setAction("Visit paintings").build());
            // [END custom_event]
            allPaintings(null);
        } else if (id == R.id.nav_favorites) {
            favorites();
        } else if (id == R.id.nav_sort_by_date) {
            if (mAllArtObjects) {
                allArtObjects(Config.ORDER_CHRONOLOGICAL);
            } else {
                allPaintings(Config.ORDER_CHRONOLOGICAL);
            }
        } else if (id == R.id.nav_sort_by_artist) {
            if (mAllArtObjects) {
                allArtObjects(Config.ORDER_BY_ARTIST);
            } else {
                allPaintings(Config.ORDER_BY_ARTIST);
            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void allArtObjects(String sortBy) {
        mAllArtObjects = true;
        Bundle arguments = new Bundle();
        if (sortBy != null) arguments.putString(Config.BUNDLE_SORT_BY, sortBy);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, fragment).addToBackStack(null).commit();
    }

    private void allPaintings(String sortBy) {
        mAllArtObjects = false;
        Bundle arguments = new Bundle();
        arguments.putString(Config.BUNDLE_QUERY, "painting");
        if (sortBy != null) arguments.putString(Config.BUNDLE_SORT_BY, sortBy);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, fragment).addToBackStack(null).commit();
    }

    private void favorites() {
        Intent intent = new Intent(this, FavActivity.class);
        startActivity(intent);
    }

    /**
     * Send email intent
     */
    private void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onFragmentInteraction(ArtObject artObject) {
        mDrawerLayout.removeDrawerListener(mToggle);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Config.BUNDLE_ART_OBJECT, artObject);
        intent.putExtra(Config.BUNDLE_ART_OBJECT_ID, artObject.getId());
        startActivity(intent);
    }
}