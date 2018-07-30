package com.example.android.android_artonmobileapp.rest;


import com.example.android.android_artonmobileapp.model.ArtObjectDetailResponse;
import com.example.android.android_artonmobileapp.model.ArtObjectResponse;
import com.example.android.android_artonmobileapp.model.StyleDetails;
import com.example.android.android_artonmobileapp.model.StylesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("en/collection")
    Call<ArtObjectResponse> getArtObjects(@Query("key") String apiKey, @Query("format") String format, @Query("ps") int resultsPerPage, @Query("imgonly") boolean imgOnly);

    @GET("en/collection")
    Call<ArtObjectResponse> getPaintings(@Query("key") String apiKey, @Query("format") String format, @Query("ps") int resultsPerPage, @Query("imgonly") boolean imgOnly, @Query("type") String type);


    @GET("en/collection")
    Call<ArtObjectResponse> getArtObjectQuery(@Query("q") String query, @Query("key") String apiKey, @Query("format") String format, @Query("ps") int resultsPerPage, @Query("imgonly") boolean imgOnly, @Query("type") String type);

    @GET("en/collection/{id}/")
    Call<ArtObjectDetailResponse> getArtObjectDetails(@Path("id") String id, @Query("key") String apiKey, @Query("format") String format);


    @GET("pages/en/rijksstudio/styles")
    Call<StylesResponse> getStyles(@Query("key") String apiKey, @Query("format") String format);

    @GET("pages/en/rijksstudio/styles/{id}/")
    Call<StyleDetails> getStyleDetails(@Path("id") String id, @Query("key") String apiKey, @Query("format") String format);
}