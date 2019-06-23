package com.example.mvp_movie_api.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetServiceMovie {
    private static NetServiceMovie netServiceMovie = new NetServiceMovie();

    private Retrofit mRetrofit;

    private NetServiceMovie(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/discover/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetServiceMovie getInstanceMovie(){
        return netServiceMovie;
    }

    public GetMovieApi getMovieApi(){
        return mRetrofit.create(GetMovieApi.class);
    }
}
