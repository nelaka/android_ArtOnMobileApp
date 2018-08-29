package com.example.android.android_artonmobileapp;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.android_artonmobileapp.database.AppDatabase;
import com.example.android.android_artonmobileapp.database.FavArtObjectDao;
import com.example.android.android_artonmobileapp.database.FavArtObjectEntry;
import com.example.android.android_artonmobileapp.model.ArtObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestRoom {

@RunWith(AndroidJUnit4.class)
public class SimpleEntityReadWriteTest {
  /*  private FavArtObjectDao mFavArtObjectDao;
    private AppDatabase mDb;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mFavArtObjectDao = mDb.favArtObjectDao();
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    @Test
    public void writeArtObjectAndReadInList() throws Exception {
        ArtObject artObject = new ArtObject("SK_A-404", "test", "test", null, "test"  );
        artObject.setId("SK_A-404");
        mFavArtObjectDao.insertFavArtObject();
        List<FavArtObjectEntry> byName = mFavArtObjectDao.loadFavArtObjectById("SK-A-404");
        assertThat(byName.get(0), equalTo(artObject));
    }
}
}String id, String title, String principalOrFirstMaker, WebImage webImage, String image
        FavArtObjectEntry(String artObjectId, String title, String maker, String imageUrl, String description )*/
}}