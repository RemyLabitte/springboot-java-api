package com.example.demo.dtos.pokemon;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ApiResult {

    private Integer count;
    private String next;
    private String previous;
    private List<NamedApiResult> results;
}
