package com.example.mvp_movie_api.rest;

import com.example.mvp_movie_api.entities.GenreEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetGenreApi {

    @GET("list")
    Call<GenreEntity> getGenreList(
            @Query("api_key") String apiKey,
            @Query("language") String lang
    );
}
