package com.example.android.android_artonmobileapp.utils;

import com.example.android.android_artonmobileapp.BuildConfig;

public class Config {

        //https://www.rijksmuseum.nl/api/en/collection?key=0MCRcrjF&format=json&q=masterpieces
        public static final String RIJKSMUSEUM_BASE_URL = "https://www.rijksmuseum.nl/api/";
        //  https://www.europeana.eu/api/v2/search.json?wskey=fgBaMgHDT&query=greece&qf=COUNTRY:greece
        public final static String rijksmuseumApiKey = BuildConfig.RIJKSMUSEUM_API_KEY;
        //  public static final String YOU_TUBE_BASE_URL = "https://www.youtube.com/watch?v=";


        public static final String RIJKSMUSEUM_STYLES = "https://www.rijksmuseum.nl/api/pages/en/rijksstudio/styles";

        public static final String BUNDLE_RECYCLER_LAYOUT = "recycler.layout";
        public static final String BUNDLE_ART_OBJECTS = "art_objects";
        public static final String BUNDLE_ART_OBJECT = "art_object";
        public static final String BUNDLE_STYLE = "style";
}
