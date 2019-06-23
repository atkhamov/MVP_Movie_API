package com.example.mvp_movie_api.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mvp_movie_api.R;
import com.example.mvp_movie_api.entities.GenreEntity;

public class GenreListViewHolder extends RecyclerView.ViewHolder {

    private TextView tvGenreName;

    public GenreListViewHolder(@NonNull View itemView) {
        super(itemView);
        this.tvGenreName = itemView.findViewById(R.id.tvGenreName);
    }

    public void bind(GenreEntity genreEntity) {
        tvGenreName.setText(String.valueOf(genreEntity.getName()));
    }
}
