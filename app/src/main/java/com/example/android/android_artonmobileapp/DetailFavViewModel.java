package com.example.android.android_artonmobileapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.android_artonmobileapp.database.AppDatabase;
import com.example.android.android_artonmobileapp.database.FavArtObjectEntry;

public class DetailFavViewModel extends ViewModel {
    // A favArtObject member variable for the FavArtObjectEntry object wrapped in a LiveData
    private LiveData<FavArtObjectEntry> favArtObject;

    public DetailFavViewModel(AppDatabase db, String favArtObjectId) {
        favArtObject = db.favArtObjectDao().loadFavArtObjectById(favArtObjectId);
    }

    // A getter for the favArtObject variable
    public LiveData<FavArtObjectEntry> getFavArtObject() {
        return favArtObject;
    }
}
