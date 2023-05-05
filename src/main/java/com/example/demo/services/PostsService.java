package com.example.demo.services;

import com.example.demo.dtos.PostComments;
import com.example.demo.dtos.jsonplaceholder.Posts;
import com.example.demo.retrofit.clients.JsonPlaceholderClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PostsService {

    private final JsonPlaceholderClient jsonPlaceholderClient;

    public PostsService(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }

    public List<Posts> retrieveAllPosts() {
        try {
            return jsonPlaceholderClient.retrieveAllPosts().execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PostComments> retrievePostsCommentsUsingPostId(Integer postId) {
        try {
            return jsonPlaceholderClient.retrievePostCommentsById(postId).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
