package com.romaqo.getamovie.service;

import com.romaqo.getamovie.entity.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MovieSourceClient implements MovieSource {

    private final String apiKey;
    private final HttpClient httpClient;

    public MovieSourceClient(@Value("${api.key}") String apiKey, HttpClient httpClient) {
        this.apiKey = apiKey;
        this.httpClient = httpClient;
    }

    @Override
    public Movie getMovieById(int movieId) {
        String url = String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s&language=en-US",
                                   movieId, apiKey);
        return httpClient.sendRequest(url);
    }

    @Override
    public Movie getLatestMovie() {
        String url = String.format("https://api.themoviedb.org/3/movie/latest?api_key=%s&language=en-US",
                                   apiKey);
        return httpClient.sendRequest(url);
    }
}
