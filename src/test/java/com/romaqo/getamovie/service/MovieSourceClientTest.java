package com.romaqo.getamovie.service;

import com.romaqo.getamovie.entity.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieSourceClientTest {

    private final static String API_KEY = "key";
    private final static int ID = 1;

    @Mock
    HttpClient httpClient;

    MovieSourceClient sourceClient;

    Movie expected;

    @BeforeEach
    void setUp() {
        expected = new Movie();
        expected.setId(ID);

        when(httpClient.sendRequest(anyString())).thenReturn(expected);
        sourceClient = new MovieSourceClient(API_KEY, httpClient);
    }

    @Test
    void testGetMovieById() {
        assertEquals(expected, sourceClient.getMovieById(ID));
    }

    @Test
    void testGetLatest() {
        assertEquals(expected, sourceClient.getLatestMovie());
    }
}