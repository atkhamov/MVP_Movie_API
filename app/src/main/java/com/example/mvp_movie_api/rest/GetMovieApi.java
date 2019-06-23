package com.example.mvp_movie_api.rest;

import com.example.mvp_movie_api.entities.MovieItemEntity;
import com.example.mvp_movie_api.entities.MovieItemEntityWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetMovieApi {

    @GET("discover/movie")
    Call<MovieItemEntityWrapper> getMovieItemList(
            @Query("api_key") String apiKey,
            @Query("language") String lang,
            @Query("sort_by") String sort
    );

}
