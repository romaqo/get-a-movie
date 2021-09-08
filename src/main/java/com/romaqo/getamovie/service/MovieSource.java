package com.romaqo.getamovie.service;

import com.romaqo.getamovie.entity.Movie;

public interface MovieSource {

    Movie getMovieById(int movieId);

    Movie getLatestMovie();
}
