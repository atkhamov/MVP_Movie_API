package com.example.mvp_movie_api.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenreEntity {

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
