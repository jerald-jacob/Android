package com.camrininfotech.mynotesapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCilnt {
    private static final String BASE_URL="https://jerald-notes.000webhostapp.com/";
    private static Retrofit retrofit;
    public static Retrofit getApiClint(){
    if(retrofit==null){
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
        return retrofit;
    }



}
