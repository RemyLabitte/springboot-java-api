package com.example.demo.retrofit.clients;

import com.example.demo.dtos.pokemon.ApiResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonClient {

    @GET("pokemon")
    Call<ApiResult> findAllPokemon(@Query("limit") String limit);
}
