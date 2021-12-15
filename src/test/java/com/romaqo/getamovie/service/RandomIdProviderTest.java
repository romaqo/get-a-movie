package com.romaqo.getamovie.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class RandomIdProviderTest {

    RandomIdProvider idProvider = new RandomIdProvider();

    @Test
    void testRandomIdInRange() {
        int min = 1, max = 10;
        int result = idProvider.getRandomId(min, max);
        assertTrue(min <= result);
        assertTrue(max > result);
    }

    @Test
    void testRandomIdWithWrongLimits() {
        int min = 10, max = 1;
        assertThrows(IllegalArgumentException.class, () -> idProvider.getRandomId(min, max));
    }
}