package com.example.demo.controllers;

import com.example.demo.dtos.pokemon.Pokemon;
import com.example.demo.services.PokemonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping(path = "/pokemons")
    public List<Pokemon> retrieveAllPokemons() throws IOException {
        return pokemonService.retrieveAllPokemons();
    }
}
