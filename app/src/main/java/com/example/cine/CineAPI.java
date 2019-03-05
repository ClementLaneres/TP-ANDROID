package com.example.cine;

import com.example.cine.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CineAPI {

    @GET("pam/cine.json")
    Call<Movies> getMovies();
}


