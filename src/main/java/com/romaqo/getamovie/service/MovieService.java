package com.romaqo.getamovie.service;

import com.romaqo.getamovie.MovieSourceClient;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieSourceClient client;
    private final Random random;

    @Autowired
    public MovieService(MovieSourceClient client) {
        this.client = client;
        this.random = new Random();
    }

    public Object getRandomMovie() {
        int movieId = getRandomId(0, 1000);
        return client.sendGetMovieRequest(movieId);
    }

    public int getRandomId(int min, int max) {
        return random.ints(min, max)
                     .findFirst()
                     .getAsInt();
    }
}
