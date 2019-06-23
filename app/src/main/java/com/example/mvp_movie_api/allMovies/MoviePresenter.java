package com.example.mvp_movie_api.allMovies;

import com.example.mvp_movie_api.entities.GenreEntity;
import com.example.mvp_movie_api.entities.MovieItemEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter implements MovieContract.Presenter {

    private MovieContract.Model model;
    private MovieContract.View view;

    public MoviePresenter(MovieContract.View view){
        this.model = new MovieModel();
        this.view = view;
    }

    @Override
    public void loadMovie(String sort_by) {
        Call<MovieItemEntity> call = model.getMovieList(sort_by);
        call.enqueue(new Callback<MovieItemEntity>() {
            @Override
            public void onResponse(Call<MovieItemEntity> call, Response<MovieItemEntity> response) {
                view.hideLoading();
                view.showMovies(response.body().getTitle());
            }

            @Override
            public void onFailure(Call<MovieItemEntity> call, Throwable t) {
                view.hideLoading();
                view.showError(t);
            }
        });

    }

    @Override
    public void loadGenre(String language) {
        Call<GenreEntity> call = model.getGenreList(language);
        call.enqueue(new Callback<GenreEntity>() {
            @Override
            public void onResponse(Call<GenreEntity> call, Response<GenreEntity> response) {
                view.hideLoading();
                view.showGenres(response.body().getId());
            }

            @Override
            public void onFailure(Call<GenreEntity> call, Throwable t) {
                view.hideLoading();
                view.showError(t);
            }
        });
    }
}
