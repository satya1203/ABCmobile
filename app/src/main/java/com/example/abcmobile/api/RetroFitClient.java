package com.example.abcmobile.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClient {
    private static final String BASE_URL = "http://192.168.0.18:8080/";
    private static Retrofit retro;

    public static Retrofit connectDB(){
        if(retro == null){
            retro = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }

}