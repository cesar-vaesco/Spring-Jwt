package com.example.spring.security.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class Apiunauthorized extends Exception {


    public Apiunauthorized(String message) {
        super(message);
    }

    private static final long serialVersionUID = 1L;

}
