package com.example.mvp_movie_api.rest;

import com.example.mvp_movie_api.entities.GenreEntity;
import com.example.mvp_movie_api.entities.GenreEntityWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetGenreApi {

    @GET("genre/movie/list")
    Call<GenreEntityWrapper> getGenreList(
            @Query("api_key") String apiKey,
            @Query("language") String lang
    );
}
