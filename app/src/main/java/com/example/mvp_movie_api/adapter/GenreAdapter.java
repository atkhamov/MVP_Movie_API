package com.example.mvp_movie_api.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp_movie_api.R;
import com.example.mvp_movie_api.entities.GenreEntity;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreListViewHolder> {

    private GenreListViewHolder genreListViewHolder;
    private List<GenreEntity> genreList;

    @NonNull
    @Override
    public GenreListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_genre_list, viewGroup, false);
        return new GenreListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GenreListViewHolder genreListViewHolder, int position) {
        genreListViewHolder.bind(genreList.get(position));
    }

    @Override
    public int getItemCount() {
        return genreList.size();
    }
}
