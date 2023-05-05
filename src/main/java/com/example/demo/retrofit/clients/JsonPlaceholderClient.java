package com.example.demo.retrofit.clients;

import com.example.demo.dtos.PostComments;
import com.example.demo.dtos.jsonplaceholder.Posts;
import com.example.demo.dtos.jsonplaceholder.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface JsonPlaceholderClient {


    @GET("/posts")
    Call<List<Posts>> retrieveAllPosts();

    @GET("/users/{id}")
    Call<User> retrieveUserById(@Path("id") Integer id);

    @GET("/posts/{postId}/comments")
    Call<List<PostComments>> retrievePostCommentsById(@Path("postId") Integer postId);
}
