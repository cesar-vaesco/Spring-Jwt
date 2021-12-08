package com.example.spring.security.services;

import java.util.UUID;

import com.example.spring.security.dto.JwtResponse;
import com.example.spring.security.dto.UsuarioDTO;
import com.example.spring.security.security.JwtIO;
import com.example.spring.security.util.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    @Autowired
    private JwtIO jwtIO;

    @Autowired
    private DateUtils dateUtils;

    @Value("${jms.jwt.token.expires-in}")
    private int EXPIRES_IN;

    UUID uid = UUID.randomUUID();

    UsuarioDTO user = UsuarioDTO
            .builder()
            .name("César")
            .lastName("Vargas")
            .role("ADMIN")
            .country("México")
            .uid(uid.toString())
            .build();

    public JwtResponse login(String clientId, String clientSecret) {

        JwtResponse jwt = JwtResponse.builder()
                .tokenType("bearer")
                .accessToken(jwtIO.generateToken(user))
                .issueAt(dateUtils.getDateMills() + "")
                .clientId(clientId)
                .expiresIn(EXPIRES_IN)
                .build();

        return jwt;
    }
}
