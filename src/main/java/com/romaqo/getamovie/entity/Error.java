package com.romaqo.getamovie.entity;

import lombok.Value;

@Value
public class Error {
    private int code;
    private String message;
}
