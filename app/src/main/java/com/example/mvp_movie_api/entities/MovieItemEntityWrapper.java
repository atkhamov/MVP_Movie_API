package com.example.mvp_movie_api.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieItemEntityWrapper {

    @Expose
    @SerializedName("results")
    private List<MovieItemEntity> movieItemEntityList;

    public List<MovieItemEntity> getMovieItemEntityList() {
        return movieItemEntityList;
    }
}
