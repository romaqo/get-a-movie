package com.romaqo.getamovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class GetAMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetAMovieApplication.class, args);
    }
}
