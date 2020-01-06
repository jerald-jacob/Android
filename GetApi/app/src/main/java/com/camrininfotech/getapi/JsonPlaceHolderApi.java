package com.camrininfotech.getapi;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId")Integer[] userId,
            @Query("userId")int userId2,
            @Query("_sort")String sort,
            @Query("_order")String order);
    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String ,String>parameters);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id")int posId);
    @GET
    Call<List<Comment>>getComments(@Url String url);
}