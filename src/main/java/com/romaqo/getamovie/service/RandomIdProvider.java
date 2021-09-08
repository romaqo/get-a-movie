package com.romaqo.getamovie.service;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class RandomIdProvider {
    private final Random random;

    public RandomIdProvider() {
        this.random = new Random();
    }

    public int getRandomId(int min, int max) {
        return random.ints(min, max)
                     .findFirst()
                     .getAsInt();
    }
}