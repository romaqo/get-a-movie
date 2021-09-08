package com.romaqo.getamovie;

import com.romaqo.getamovie.entity.Error;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({HttpClientErrorException.NotFound.class})
    public ResponseEntity<Error> handleNotFoundException(Exception ex) {
        Error error = new Error(HttpStatus.NOT_FOUND.value(),
                                "The resource you requested could not be found.");
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Error> handleUnexpectedException(Exception ex) {
        Error error = new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                "Unexpected error.");
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
