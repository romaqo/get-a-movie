package com.romaqo.getamovie.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class RandomIdProviderTest {

    RandomIdProvider idProvider = new RandomIdProvider();

    @Test
    void testIdInRange() {
        int min = 1, max = 2;
        int result = idProvider.getRandomId(min, max);
        assertTrue(min <= result);
        assertTrue(max > result);
    }
}