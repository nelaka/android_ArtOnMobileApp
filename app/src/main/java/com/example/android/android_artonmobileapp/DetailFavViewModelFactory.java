package com.example.android.android_artonmobileapp;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.android.android_artonmobileapp.database.AppDatabase;

public class DetailFavViewModelFactory extends ViewModelProvider.NewInstanceFactory{

    private final AppDatabase mDb;
    private final String mArtObjectId;

    // Initialize the member variables in the constructor with the parameters received
    public DetailFavViewModelFactory(AppDatabase db, String artObjectId) {
        mDb = db;
        mArtObjectId = artObjectId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new DetailFavViewModel(mDb, mArtObjectId);
    }
}