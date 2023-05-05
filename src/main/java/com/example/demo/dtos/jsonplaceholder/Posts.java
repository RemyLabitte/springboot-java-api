package com.example.demo.dtos.jsonplaceholder;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Posts {

    public Integer id;
    public Integer userId;
    public String title;
    public String body;
}
