package com.romaqo.getamovie.service;

import com.romaqo.getamovie.entity.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    private final static int LATEST_ID = 10;

    @Mock
    MovieSource source;
    @Mock
    RandomIdProvider idProvider;

    @InjectMocks
    MovieService service;

    @Test
    void testGetRandomMovie() {
        int id = 2;
        Movie expected = createStubMovie(id);
        when(source.getMovieById(id)).thenReturn(expected);
        when(source.getLatestMovie()).thenReturn(createStubMovie(LATEST_ID));
        when(idProvider.getRandomId(anyInt(), anyInt())).thenReturn(id);

        assertEquals(expected, service.getRandomMovie());
        verify(source).getLatestMovie();
        verify(source).getMovieById(id);
    }

    private Movie createStubMovie(int id) {
        Movie movie = new Movie();
        movie.setId(id);
        return movie;
    }
}