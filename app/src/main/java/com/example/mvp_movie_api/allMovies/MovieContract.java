package com.example.mvp_movie_api.allMovies;

import com.example.mvp_movie_api.entities.GenreEntity;
import com.example.mvp_movie_api.entities.MovieItemEntity;

import java.util.List;

import retrofit2.Call;

public interface MovieContract {

    interface View{
        void showLoading();
        void hideLoading();
        void showMovies(List<MovieItemEntity> listMovieItemEntity);
        void showGenres(List<GenreEntity> listGenreEntity);
        void showError(Throwable throwable);
    }

    interface Presenter{
        void loadMovie(String sort_by);
        void loadGenre(String language);
    }

    interface Model{
        Call<MovieItemEntity> getMovieList(String sort_by);
        Call<GenreEntity> getGenreList(String language);
    }
}
