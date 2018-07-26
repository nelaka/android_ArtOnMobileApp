package com.example.android.android_artonmobileapp;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.android.android_artonmobileapp.model.ArtObject;
import com.example.android.android_artonmobileapp.utils.Config;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //final ActionBar actionbar = getSupportActionBar();
      //  actionbar.setDisplayHomeAsUpEnabled(true);
      //  actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

}



    @Override
    public void onFragmentInteraction(ArtObject artObject) {

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Config.BUNDLE_ART_OBJECT, artObject);

        startActivity(intent);
        //startActivityForResult(intent, CHANGES_IN_FAV_MOVIES)

    }
}
