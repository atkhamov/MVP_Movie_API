package com.example.mvp_movie_api.allMovies;

import com.example.mvp_movie_api.entities.GenreEntityWrapper;
import com.example.mvp_movie_api.entities.MovieItemEntityWrapper;
import com.example.mvp_movie_api.rest.NetworkService;

import retrofit2.Call;

public class MainPageModel implements MainPageContract.Model {
    @Override
    public Call<MovieItemEntityWrapper> getMovieList(String sort_by) {
        return NetworkService
                .getInstance()
                .getMovieApi()
                .getMovieItemList("e9ba83833d52641138a17e76413d2f32", "en-US", sort_by);
    }

    @Override
    public Call<GenreEntityWrapper> getGenreList(String language) {
        return NetworkService
                .getInstance()
                .getGenreApi()
                .getGenreList("e9ba83833d52641138a17e76413d2f32", language);
    }
}
