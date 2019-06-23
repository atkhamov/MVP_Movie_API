package com.example.mvp_movie_api.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenreEntityWrapper {

    @Expose
    @SerializedName("genres")
    private List<GenreEntity> genreEntityList;

    public List<GenreEntity> getGenreEntityList() {
        return genreEntityList;
    }
}
