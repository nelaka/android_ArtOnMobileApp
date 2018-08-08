package com.example.android.android_artonmobileapp;

import android.content.Intent;
import android.content.Loader;
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
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    ActionBarDrawerToggle mToggle;
    @BindView(R.id.fab_mail)
    FloatingActionButton mFab;
    Tracker mTracker;
    private Boolean mAllArtObjects = true;
    private Loader mLoader;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Why don' t you suggest this app to your friends? Send them an e-mail now!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                composeEmail(null, "Maybe you should check out this app! It's awesome!");
            }
        });

        // Obtain the shared Tracker instance.
        AnalyticsApp application = (AnalyticsApp) getApplication();
        mTracker = application.getDefaultTracker();


        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);
        if (getLoaderManager().getLoader(Config.ID_FAV_ITEMS_LOADER) != null) {
            mLoader = getLoaderManager().getLoader(Config.ID_FAV_ITEMS_LOADER);
            mLoader.reset();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //  mLoader.reset();

        String name = "Main Activity";
        Log.i("MainActivity", "Setting screen name: " + name);
        mTracker.setScreenName("Image~" + name);
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
            // [START custom_event]
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
    public void composeEmail(String[] addresses, String subject) {
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
        intent.putExtra(Config.BUNDLE_ART_OBJECT_ID, artObject.getId());
        startActivity(intent);
    }
}