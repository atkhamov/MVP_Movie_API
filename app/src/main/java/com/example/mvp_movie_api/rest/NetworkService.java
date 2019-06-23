package com.example.mvp_movie_api.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService netServiceGenre = new NetworkService();

    private Retrofit mRetrofit;

    private NetworkService(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance(){
        return netServiceGenre;
    }

    public GetGenreApi getGenreApi(){
        return mRetrofit.create(GetGenreApi.class);
    }

    public GetMovieApi getMovieApi(){
        return mRetrofit.create(GetMovieApi.class);
    }
}
