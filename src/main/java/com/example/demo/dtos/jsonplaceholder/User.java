package com.example.demo.dtos.jsonplaceholder;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User {

    public String name;
    public String email;
    public String website;
}
