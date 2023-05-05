package com.example.demo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PostComments {

    public Integer postId;
    public Integer id;
    public String name;
    public String email;
    public String body;
}
