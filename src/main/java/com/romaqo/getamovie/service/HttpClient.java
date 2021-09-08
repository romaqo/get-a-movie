package com.romaqo.getamovie.service;

import com.romaqo.getamovie.entity.Movie;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClient {

    private final RestTemplate restTemplate;

    public HttpClient() {
        this.restTemplate = new RestTemplate();
    }

    public Movie sendRequest(String url) {
        RequestEntity<Void> request = RequestEntity.get(url)
                                                   .accept(MediaType.APPLICATION_JSON).build();
            return restTemplate.exchange(request, Movie.class).getBody();
    }
}
