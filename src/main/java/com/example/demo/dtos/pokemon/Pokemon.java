package com.example.demo.dtos.pokemon;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
@Data
public class Pokemon {

    private Integer id;
    private String name;
    private List<Abilities> abilities;
}
