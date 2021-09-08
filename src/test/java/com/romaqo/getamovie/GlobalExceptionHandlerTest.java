package com.romaqo.getamovie;

import com.romaqo.getamovie.entity.Error;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void handleNotFoundException() {
        Error expected = new Error(HttpStatus.NOT_FOUND.value(),
                                "The resource you requested could not be found.");
        HttpClientErrorException exception = HttpClientErrorException.create(HttpStatus.NOT_FOUND, "not found", null, null, null);
        ResponseEntity<Error> result = handler.handleNotFoundException(exception);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        assertEquals(expected, result.getBody());
    }

    @Test
    void handleUnexpectedException() {
        Error expected = new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                   "Unexpected error.");
        ResponseEntity<Error> result = handler.handleUnexpectedException(new RuntimeException());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertEquals(expected, result.getBody());
    }
}