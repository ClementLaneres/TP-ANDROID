package com.example.cine;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIHelper {
    private CineAPI newsApi;

    public CineAPI getCineAPI() {
        return newsApi;
    }

    private APIHelper() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://etudiants.openium.fr/").addConverterFactory(GsonConverterFactory.create()).build();
        newsApi = retrofit.create(CineAPI.class);
    }

    private static volatile APIHelper instance;


    public static synchronized APIHelper getInstance() {
        if (instance == null) {
            instance = new APIHelper();
        }
        return instance;
    }

}
