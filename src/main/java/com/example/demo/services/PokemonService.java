package com.example.demo.services;

import com.example.demo.dtos.pokemon.ApiResult;
import com.example.demo.dtos.pokemon.NamedApiResult;
import com.example.demo.dtos.pokemon.Pokemon;
import com.example.demo.retrofit.clients.PokemonClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class PokemonService {

    private final PokemonClient pokemonClient;

    public PokemonService(PokemonClient pokemonClient) {
        this.pokemonClient = pokemonClient;
    }

    public List<Pokemon> retrieveAllPokemons() throws IOException {

        RestTemplate restTemplate = new RestTemplate();

        Response<ApiResult> response = pokemonClient.findAllPokemon(String.valueOf(15)).execute();
        if (response.isSuccessful() && null != response.body()) {
            List<NamedApiResult> pokemonsResult = response.body().getResults();
            List<Pokemon> pokemons = pokemonsResult.stream().map(pokemonResult -> {
                Pokemon pokemon = restTemplate.getForObject(pokemonResult.getUrl(), Pokemon.class);
                return pokemon;
            }).toList();

            return pokemons;
        }
        return List.of();
    }
}
