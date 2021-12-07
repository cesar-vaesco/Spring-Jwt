package com.example.spring.security.services;

import com.example.spring.security.dto.JwtResponse;

import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    public JwtResponse login(String clientId, String clientSecret) {

        JwtResponse jwt = JwtResponse.builder()
        .tokenType("bearer")
        .accessToken("asdasdasasd")
        .issueAt(System.currentTimeMillis()+ "")
        .clientId(clientId)
        .expiresIn(3600)
        .build();

        return jwt;
    }
}
