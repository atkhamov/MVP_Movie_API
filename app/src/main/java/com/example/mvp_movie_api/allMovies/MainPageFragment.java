package com.example.mvp_movie_api.allMovies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mvp_movie_api.R;
import com.example.mvp_movie_api.adapter.GenreAdapter;
import com.example.mvp_movie_api.adapter.MovieAdapter;
import com.example.mvp_movie_api.adapter.ReachEndListener;
import com.example.mvp_movie_api.entities.GenreEntity;
import com.example.mvp_movie_api.entities.MovieItemEntity;

import java.util.List;


public class MainPageFragment extends Fragment implements MainPageContract.View, ReachEndListener {

    private MovieAdapter movieAdapter;
    private RecyclerView recyclerViewMovies;
    private MainPageContract.Presenter mainPagePresenter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private TextView tvTopMovieName;
    private TextView tvTopMovieRate;
    private TextView tvGenreName;
    private int page;

    private RecyclerView recyclerViewGenre;
    private GenreAdapter genreAdapter;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        movieAdapter = new MovieAdapter();
        mainPagePresenter = new MainPagePresenter(this);
        progressBar = view.findViewById(R.id.progBar);
        tvTopMovieName = view.findViewById(R.id.tvMovieName);
        tvTopMovieRate = view.findViewById(R.id.tvMovieRate);
        tvGenreName = view.findViewById(R.id.tvGenreName);


        //LinearLayoutManager layoutManager
        //    = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);


        recyclerViewMovies = view.findViewById(R.id.rvListMovies);
        recyclerViewMovies.setAdapter(movieAdapter);
        recyclerViewMovies.setLayoutManager(layoutManager);
        mainPagePresenter.loadMovie(1);


        recyclerViewGenre = view.findViewById(R.id.rvGenreList);
        genreAdapter = new GenreAdapter();
        recyclerViewGenre.setAdapter(genreAdapter);
        recyclerViewGenre.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        mainPagePresenter.loadGenre("en-US");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_page, container, false);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMovies(List<MovieItemEntity> listMovieItemEntity) {
        movieAdapter.addMovieItemEntityList(listMovieItemEntity);
        tvTopMovieName.setText(listMovieItemEntity.get(0).getTitle());
        tvTopMovieRate.setText(String.valueOf(listMovieItemEntity.get(0).getVoteAverage()));
    }

    @Override
    public void showGenres(List<GenreEntity> listGenreEntity) {
//        genreAdapter.addGenreEntityList(listGenreEntity);
//        tvGenreName.setText(listGenreEntity.get(0).getName());
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void onReachEnd() {
        page++;
        mainPagePresenter.loadMovie(page);
    }
}
