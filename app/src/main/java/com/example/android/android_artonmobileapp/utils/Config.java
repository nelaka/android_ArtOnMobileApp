package com.example.android.android_artonmobileapp.utils;

import com.example.android.android_artonmobileapp.BuildConfig;

public class Config {

    //https://www.rijksmuseum.nl/api/en/collection?key=0MCRcrjF&format=json
    public static final String RIJKSMUSEUM_BASE_URL = "https://www.rijksmuseum.nl/api/";
    public final static String rijksmuseumApiKey = BuildConfig.RIJKSMUSEUM_API_KEY;

    public static final String BUNDLE_RECYCLER_LAYOUT = "recycler.layout";
    public static final String BUNDLE_ART_OBJECTS = "art_objects";
    public static final String BUNDLE_ART_OBJECT = "art_object";
    public static final String BUNDLE_ART_OBJECT_ID = "art_object_id";
    public static final String BUNDLE_QUERY = "query";
    public static final String BUNDLE_SORT_BY = "sort_by";

    public static final int RESULTS_RETURNED = 60;

    public static final String ORDER_CHRONOLOGICAL = "chronologic";
    public static final String ORDER_BY_ARTIST = "artist";
}