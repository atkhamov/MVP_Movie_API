package com.example.mvp_movie_api.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp_movie_api.R;
import com.example.mvp_movie_api.entities.MovieItemEntity;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieListViewHolder> {

    private MovieListViewHolder movieListViewHolder;
    private List<MovieItemEntity> movieItemEntityList;

    public List<MovieItemEntity> getMovieItemEntityList(){
        return movieItemEntityList;
    }

    public MovieAdapter(){
        this.movieItemEntityList = new ArrayList<>();
    }

    public void setMovieItemEntityList(List<MovieItemEntity> movieItemEntityList){
        this.movieItemEntityList.clear();
        this.movieItemEntityList.addAll(movieItemEntityList);
        notifyDataSetChanged();
    }

    public void addMovieItemEntityList(List<MovieItemEntity> movieItemEntityList){
        this.movieItemEntityList.addAll(movieItemEntityList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new MovieListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieListViewHolder movieListViewHolder, int position) {
        movieListViewHolder.bind(movieItemEntityList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieItemEntityList.size();
    }
}
