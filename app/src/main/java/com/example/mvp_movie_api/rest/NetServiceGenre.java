package com.example.mvp_movie_api.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetServiceGenre {

    private static NetServiceGenre netServiceGenre = new NetServiceGenre();

    private Retrofit mRetrofit;

    private NetServiceGenre(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/genre/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetServiceGenre getInstanceGenre(){
        return netServiceGenre;
    }

    public GetGenreApi getGenreApi(){
        return mRetrofit.create(GetGenreApi.class);
    }
}
