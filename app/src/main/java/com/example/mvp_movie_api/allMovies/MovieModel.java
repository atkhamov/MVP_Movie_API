package com.example.mvp_movie_api.allMovies;

import com.example.mvp_movie_api.entities.GenreEntity;
import com.example.mvp_movie_api.entities.MovieItemEntity;
import com.example.mvp_movie_api.rest.NetServiceGenre;
import com.example.mvp_movie_api.rest.NetServiceMovie;

import retrofit2.Call;

public class MovieModel implements MovieContract.Model {
    @Override
    public Call<MovieItemEntity> getMovieList(String sort_by) {
        return NetServiceMovie
                .getInstanceMovie()
                .getMovieApi()
                .getMovieItemList("e9ba83833d52641138a17e76413d2f32", "en-US", sort_by);
    }

    @Override
    public Call<GenreEntity> getGenreList(String language) {
        return NetServiceGenre
                .getInstanceGenre()
                .getGenreApi()
                .getGenreList("e9ba83833d52641138a17e76413d2f32", language);
    }
}
