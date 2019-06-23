package com.example.mvp_movie_api.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvp_movie_api.R;
import com.example.mvp_movie_api.entities.MovieItemEntity;

public class MovieListViewHolder extends RecyclerView.ViewHolder {

    private ImageView moviePoster;
    private TextView movieItemName;
    private TextView movieItemRate;

    public MovieListViewHolder(@NonNull View itemView) {
        super(itemView);
        this.moviePoster = itemView.findViewById(R.id.ivMoviePoster);
        this.movieItemName = itemView.findViewById(R.id.tvItemName);
        this.movieItemRate = itemView.findViewById(R.id.tvItemRate);
    }

    public void bind(MovieItemEntity movieItemEntity){
        movieItemName.setText(String.valueOf(movieItemEntity.getTitle()));
        movieItemRate.setText(String.valueOf(movieItemEntity.getVoteAverage()));

        Glide.with(itemView)
                .load(movieItemEntity.getPosterPath())
                .into(moviePoster);
    }
}
