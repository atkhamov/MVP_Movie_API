package com.example.mvp_movie_api.allMovies;

import com.example.mvp_movie_api.entities.GenreEntity;
import com.example.mvp_movie_api.entities.GenreEntityWrapper;
import com.example.mvp_movie_api.entities.MovieItemEntity;
import com.example.mvp_movie_api.entities.MovieItemEntityWrapper;

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
        Call<MovieItemEntityWrapper> call = model.getMovieList(sort_by);
        call.enqueue(new Callback<MovieItemEntityWrapper>() {
            @Override
            public void onResponse(Call<MovieItemEntityWrapper> call, Response<MovieItemEntityWrapper> response) {
                view.hideLoading();
                view.showMovies(response.body().getMovieItemEntityList());
            }

            @Override
            public void onFailure(Call<MovieItemEntityWrapper> call, Throwable t) {
                view.hideLoading();
                view.showError(t);
            }
        });


    }

    @Override
    public void loadGenre(String language) {
        Call<GenreEntityWrapper> call = model.getGenreList(language);
        call.enqueue(new Callback<GenreEntityWrapper>() {
            @Override
            public void onResponse(Call<GenreEntityWrapper> call, Response<GenreEntityWrapper> response) {
                view.hideLoading();
                view.showGenres(response.body().getGenreEntityList());
            }

            @Override
            public void onFailure(Call<GenreEntityWrapper> call, Throwable t) {
                view.hideLoading();
                view.showError(t);
            }
        });
//        Call<GenreEntity> call = model.getGenreList(language);
//        call.enqueue(new Callback<GenreEntity>() {
//            @Override
//            public void onResponse(Call<GenreEntity> call, Response<GenreEntity> response) {
//                view.hideLoading();
//                view.showGenres(response.body().);
//            }
//
//            @Override
//            public void onFailure(Call<GenreEntity> call, Throwable t) {
//                view.hideLoading();
//                view.showError(t);
//            }
//        });
    }
}
