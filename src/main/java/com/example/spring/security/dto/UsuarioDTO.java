package com.example.spring.security.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UsuarioDTO implements Serializable {



    private String uid;
    private String name;
    private String lastName;
    private String role;
    private String country;


    private static final long serialVersionUID = 1L;


}
