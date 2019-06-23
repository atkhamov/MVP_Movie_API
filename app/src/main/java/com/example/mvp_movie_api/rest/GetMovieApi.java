package com.example.mvp_movie_api.rest;

import com.example.mvp_movie_api.entities.MovieItemEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetMovieApi {

    @GET("movie")
    Call<MovieItemEntity> getMovieItemList(
            @Query("api_key") String apiKey,
            @Query("language") String lang,
            @Query("sort_by") String sort
    );

}
