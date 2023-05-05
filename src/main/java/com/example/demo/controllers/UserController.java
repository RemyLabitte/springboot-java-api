package com.example.demo.controllers;

import com.example.demo.dtos.jsonplaceholder.User;
import com.example.demo.services.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UsersService usersService;


    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/{id}")
    public User retrieveUserById(@PathVariable("id") Integer userId) {
        return usersService.retrieveUserById(userId);
    }
}
