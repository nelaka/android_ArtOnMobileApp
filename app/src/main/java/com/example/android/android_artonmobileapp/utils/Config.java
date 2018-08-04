package com.example.android.android_artonmobileapp.utils;

import com.example.android.android_artonmobileapp.BuildConfig;

public class Config {

        //https://www.rijksmuseum.nl/api/en/collection?key=0MCRcrjF&format=json&q=masterpieces
        public static final String RIJKSMUSEUM_BASE_URL = "https://www.rijksmuseum.nl/api/";
        //  https://www.europeana.eu/api/v2/search.json?wskey=fgBaMgHDT&query=greece&qf=COUNTRY:greece
        public final static String rijksmuseumApiKey = BuildConfig.RIJKSMUSEUM_API_KEY;
        //  public static final String YOU_TUBE_BASE_URL = "https://www.youtube.com/watch?v=";


    //    public static final String RIJKSMUSEUM_STYLES = "https://www.rijksmuseum.nl/api/pages/en/rijksstudio/styles";

        public static final String BUNDLE_RECYCLER_LAYOUT = "recycler.layout";
        public static final String BUNDLE_ART_OBJECTS = "art_objects";

    public static final String BUNDLE_QUERY = "query";
    public static final String BUNDLE_PAINTING = "painting";
    public static final int NEED_TO_REFRESH_LIST = 0;  // The request code
    public static final int CHANGES_IN_FAV_ITEMS = 1;  // The request code
    public static final String BUNDLE_ART_OBJECT_ID = "art_object_id";

    public static final String BUNDLE_FAVORITES = "favorites";

    /*
     * This ID will be used to identify the Loader responsible for loading our weather forecast. In
     * some cases, one Activity can deal with many Loaders. However, in our case, there is only one.
     * We will still use this ID to initialize the loader and create the loader for best practice.
     * Please note that 44 was chosen arbitrarily. You can use whatever number you like, so long as
     * it is unique and consistent.
     */
    public static final int ID_FAV_ITEMS_LOADER = 44;


}

