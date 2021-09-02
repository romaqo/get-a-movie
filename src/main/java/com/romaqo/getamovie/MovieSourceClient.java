package com.romaqo.getamovie;

import com.romaqo.getamovie.entity.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieSourceClient {

    private final String apiKey;
    private final ParameterizedTypeReference<Object> responseType;

    public MovieSourceClient(@Value("${api.key}") String apiKey) {
        this.apiKey = apiKey;
        responseType = new ParameterizedTypeReference<Object>() {};
    }

    public Object sendGetMovieRequest(int movieId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s&language=en-US",
                                   movieId, apiKey);
        RequestEntity<Void> request = RequestEntity.get(url)
                                                   .accept(MediaType.APPLICATION_JSON).build();
        Object jsonDictionary = restTemplate.exchange(request, Movie.class).getBody();
//        Object jsonDictionary = restTemplate.exchange(request, responseType).getBody();
        return jsonDictionary;
    }
}
