package com.example.demo.services;

import com.example.demo.dtos.jsonplaceholder.User;
import com.example.demo.retrofit.clients.JsonPlaceholderClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UsersService {

    private final JsonPlaceholderClient jsonPlaceholderClient;


    public UsersService(JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }

    public User retrieveUserById(Integer id) {
        try {
            return jsonPlaceholderClient.retrieveUserById(id).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
