package com.romaqo.getamovie.service;

import com.romaqo.getamovie.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieSource source;
    private final RandomIdProvider randomIdProvider;

    @Autowired
    public MovieService(MovieSource source, RandomIdProvider randomIdProvider) {
        this.source = source;
        this.randomIdProvider = randomIdProvider;
    }

    public Movie getRandomMovie() {
        int movieId = randomIdProvider.getRandomId(0, getLatestId());
        return source.getMovieById(movieId);
    }

    private int getLatestId() {
        return source.getLatestMovie().getId();
    }
}
