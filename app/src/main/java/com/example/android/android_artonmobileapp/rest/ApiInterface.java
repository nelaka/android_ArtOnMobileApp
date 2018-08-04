package com.example.android.android_artonmobileapp.rest;


import com.example.android.android_artonmobileapp.model.ArtObjectDetailResponse;
import com.example.android.android_artonmobileapp.model.ArtObjectResponse;

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

    @GET("en/collection/{objectNumber}")
    Call<ArtObjectDetailResponse> getArtObjectDetails(@Path("objectNumber") String objectNumber, @Query("key") String apiKey, @Query("format") String format);


}