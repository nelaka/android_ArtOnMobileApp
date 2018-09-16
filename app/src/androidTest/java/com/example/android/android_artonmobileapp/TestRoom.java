package com.example.android.android_artonmobileapp;

import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;

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