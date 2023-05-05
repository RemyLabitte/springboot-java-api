package com.example.demo.controllers;

import com.example.demo.dtos.PostComments;
import com.example.demo.dtos.jsonplaceholder.Posts;
import com.example.demo.services.PostsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostsController {

    private final PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping
    public List<Posts> retrievePostsFromUsers() {
        return postsService.retrieveAllPosts();
    }

    @GetMapping("{postId}/comments")
    public List<PostComments> retrievePostsComments(@PathVariable("postId") Integer postId) {
        return postsService.retrievePostsCommentsUsingPostId(postId);
    }
}
