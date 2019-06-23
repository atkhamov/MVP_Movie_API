package com.example.mvp_movie_api.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieItemEntity {

    @Expose
    @SerializedName("poster_path")
    private String posterPath;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("vote_average")
    private double voteAverage;

    @Expose
    @SerializedName("genre_ids")
    private ArrayList<Integer> genreIDs;

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public ArrayList<Integer> getGenreIDs() {
        return genreIDs;
    }
}
