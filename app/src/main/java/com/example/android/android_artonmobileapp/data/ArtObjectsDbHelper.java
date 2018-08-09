package com.example.android.android_artonmobileapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.android_artonmobileapp.data.ArtObjectsContract.ArtObjectsEntry;

class ArtObjectsDbHelper extends SQLiteOpenHelper {

    /*
     * This is the name of our database. Database names should be descriptive and end with the
     * .db extension.
     */
    private static final String DATABASE_NAME = "artObjects.db";

    /*
     * If you change the database schema, you must increment the database version or the onUpgrade
     * method will not be called.
     */
    private static final int DATABASE_VERSION = 1;

    public ArtObjectsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when the database is created for the first time. This is where the creation of
     * tables and the initial population of the tables should happen.
     *
     * @param sqLiteDatabase The database.
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*
         * This String will contain a simple SQL statement that will create a table that will
         * cache our movie data.
         */
        final String SQL_CREATE_ARTOBJECTS_TABLE =

                "CREATE TABLE " + ArtObjectsEntry.TABLE_NAME + " (" + ArtObjectsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ArtObjectsEntry.COLUMN_ART_OBJECT_ID + " TEXT NOT NULL, " + ArtObjectsEntry.COLUMN_TITLE + " TEXT NOT NULL, " + ArtObjectsEntry.COLUMN_MAKER + " TEXT, " + ArtObjectsEntry.COLUMN_IMAGE + " TEXT NOT NULL, " + ArtObjectsEntry.COLUMN_DESC + " TEXT " + ");";

        /*
         * Execute SQL with the execSQL method of the SQLite database object.
         */
        sqLiteDatabase.execSQL(SQL_CREATE_ARTOBJECTS_TABLE);
    }

    /**
     * This database is only a cache for online data, so its upgrade policy is simply to discard
     * the data and call through to onCreate to recreate the table. Note that this only fires if
     * you change the version number for your database (in our case, DATABASE_VERSION). It does NOT
     * depend on the version number for your application found in your app/build.gradle file. If
     * you want to update the schema without wiping data, commenting out the current body of this
     * method should be your top priority before modifying this method.
     *
     * @param sqLiteDatabase Database that is being upgraded
     * @param oldVersion     The old database version
     * @param newVersion     The new database version
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}