package com.example.mvp_movie_api.allMovies;

import com.example.mvp_movie_api.entities.GenreEntityWrapper;
import com.example.mvp_movie_api.entities.MovieItemEntityWrapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPagePresenter implements MainPageContract.Presenter {

    private MainPageContract.Model model;
    private MainPageContract.View view;

    public MainPagePresenter(MainPageContract.View view){
        this.model = new MainPageModel();
        this.view = view;
    }

    @Override
    public void loadMovie(String sort_by) {
        view.showLoading();
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
//                view.hideLoading();
                view.showGenres(response.body().getGenreEntityList());
            }

            @Override
            public void onFailure(Call<GenreEntityWrapper> call, Throwable t) {
//                view.hideLoading();
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
