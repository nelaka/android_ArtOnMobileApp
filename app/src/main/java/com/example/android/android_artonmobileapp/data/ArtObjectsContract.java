package com.example.android.android_artonmobileapp.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class ArtObjectsContract {

    /*
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website. A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * Play Store.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.android_artonmobileapp";
    /*
     * Possible paths that can be appended to BASE_CONTENT_URI to form valid URI's that ArtOnMobile
     * can handle. For instance,
     *
     *     content://com.example.android.android_artonmobileapp/styles/
     *     [           BASE_CONTENT_URI         ][ PATH_STYLES ]
     *
     * is a valid path for looking at artObjects data.
     *
     *      content://com.example.android.android_artonmobile/givemeroot/
     *
     * will fail, as the ContentProvider hasn't been given any information on what to do with
     * "givemeroot". At least, let's hope not. Don't be that dev, reader. Don't be that dev.
     */
    public static final String PATH_FAV = "fav_art";
    /*
     * CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider for Art on Mobile.
     */
    private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /* Inner class that defines the table contents of the favArtObjects table */
    public static final class ArtObjectsEntry implements BaseColumns {
        /* The base CONTENT_URI used to query the ArtObjects table from the content provider */
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_FAV).build();

        /* Used internally as the name of fav_art table. */
        public static final String TABLE_NAME = "fav_art";
        /* Movie ID as returned by API, used to identify the trailer to be used */
        public static final String COLUMN_ART_OBJECT_ID = "id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_MAKER = "maker";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_DESC = "description";

    }


}