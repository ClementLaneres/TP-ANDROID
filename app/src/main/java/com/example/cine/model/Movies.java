package com.example.cine.model;

import java.util.List;

public class Movies {
    public List<Movie> movieShowtimes;

    public Movie get(int pos){
        return movieShowtimes.get(pos);
    }
}
