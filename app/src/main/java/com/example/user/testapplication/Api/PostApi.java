package com.example.user.testapplication.Api;

import com.example.user.testapplication.Model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface  PostApi {

    @GET("/posts")
    Call<List<Post>> GetPostList();

    @GET("/posts/{id}")
    Call<List<Post>> GetPostById(@Path("id") int id);

    @POST("/posts")
    Call<Post> PostPost(@Body Post person);
}
