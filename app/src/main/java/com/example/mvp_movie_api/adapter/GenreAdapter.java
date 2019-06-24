package com.example.mvp_movie_api.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp_movie_api.R;
import com.example.mvp_movie_api.entities.GenreEntity;
import com.example.mvp_movie_api.entities.GenreEntityWrapper;

import java.util.ArrayList;
import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreListViewHolder> {

    private GenreListViewHolder genreListViewHolder;
    private List<GenreEntityWrapper> genreList;
    private List<GenreEntity> genreEntityList;


    private List<GenreEntity> getGenreEntityList(){
        return genreEntityList;
    }

    public GenreAdapter(){
        this.genreEntityList = new ArrayList<>();
    }

    public void setGenreEntityList(List<GenreEntity> genreEntityList){
        this.genreEntityList.clear();
        this.genreEntityList.addAll(genreEntityList);
        notifyDataSetChanged();
    }

    public void addGenreEntityList(List<GenreEntity> genreEntityList){
        this.genreEntityList.addAll(genreEntityList);
        notifyDataSetChanged();
    }

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
        return genreEntityList.size();
    }
}
