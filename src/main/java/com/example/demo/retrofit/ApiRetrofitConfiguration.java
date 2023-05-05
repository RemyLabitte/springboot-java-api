package com.example.demo.retrofit;

import com.example.demo.retrofit.clients.JsonPlaceholderClient;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import com.example.demo.retrofit.clients.PokemonClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
public class ApiRetrofitConfiguration {

    @Value("${api.pokemon.url}")
    protected String pokemonBaseUrl;

    @Value("${api.jsonplaceholder.url}")
    protected String jsonplaceholderBaseUrl;


    @Bean
    public PokemonClient pokemonClient() {

        return new Retrofit.Builder()
                .baseUrl(pokemonBaseUrl)
                .client(getRequestHeader())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonClient.class);
    }

    @Bean
    public JsonPlaceholderClient jsonPlaceholderClient() {

        return new Retrofit.Builder()
                .baseUrl(jsonplaceholderBaseUrl)
                .client(getRequestHeader())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JsonPlaceholderClient.class);
    }

    private OkHttpClient getRequestHeader() {
        return new OkHttpClient.Builder()
                .readTimeout(300, TimeUnit.SECONDS)
                .connectTimeout(300, TimeUnit.SECONDS)
                .writeTimeout(300, TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    Request request = chain.request().newBuilder()
                            .addHeader("Accept", String.valueOf(MediaType.APPLICATION_JSON))
                            .addHeader("Content-Type", String.valueOf(MediaType.APPLICATION_JSON))
                            .build();
                    return chain.proceed(request);
                })
                .build();
    }
}