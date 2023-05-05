package com.example.demo.dtos.pokemon;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
@Data
public class Abilities {

    @JsonProperty("is_hidden")
    private boolean isHidden;

    private Integer slot;

    private NamedApiResult ability;
}
