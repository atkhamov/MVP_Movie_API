package com.example.mvp_movie_api;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvp_movie_api.allMovies.MainPageFragment;

public class MainActivity extends AppCompatActivity {

    private MainPageFragment mainPageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPageFragment = new MainPageFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();

        //ft.add(R.id.fragment_container,fragment).commit();

        fragmentManager.beginTransaction().add(R.id.fragmentContainer, mainPageFragment).commit();

    }
}
