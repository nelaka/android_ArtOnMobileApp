package com.example.android.android_artonmobileapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.android_artonmobileapp.database.AppDatabase;
import com.example.android.android_artonmobileapp.database.FavArtObjectEntry;

import java.util.List;

public class FavViewModel extends AndroidViewModel {


    // Constant for logging
    private static final String TAG = FavViewModel.class.getSimpleName();

    // Add a favArtObjects member variable for a list of FavArtObjectEntry objects wrapped in a LiveData
    private LiveData<List<FavArtObjectEntry>> favArtObjects;

    public FavViewModel(@NonNull Application application) {
        super(application);
        // In the constructor use the loadAllTasks of the taskDao to initialize the favArtObjects variable
        AppDatabase db = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the favArtObjects from the DataBase");
        favArtObjects = db.favArtObjectDao().loadAllFavArtObjects();
    }

    // Create a getter for the favArtObjects variable
    public LiveData<List<FavArtObjectEntry>> getFavArtObjects() {
        return favArtObjects;
    }
}
