package com.example.user.testapplication.Service;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.example.user.testapplication.Api.PostApi;
import com.example.user.testapplication.Model.Post;
import com.example.user.testapplication.Tools.RetroClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by User on 16.11.2017.
 */

public class PostService {


    public PostService(){
    }

    public Call<List<Post>> GetPostList(){

        PostApi api = RetroClient.getClient().create(PostApi.class);
        return api.GetPostList();

//        return null;

    }

}
