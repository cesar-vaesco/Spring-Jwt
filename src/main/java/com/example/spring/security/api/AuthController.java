package com.example.spring.security.api;

import com.example.spring.security.exceptions.Apiunauthorized;
import com.example.spring.security.services.AuthServices;
import com.example.spring.security.validators.AuthValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1.0")
public class AuthController {

    @Autowired
    private AuthServices authService;

    @Autowired
    private AuthValidator validator;

    @PostMapping(path = "/oauth/client_credential/accesstoken", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@RequestBody MultiValueMap<String, String> paramMap,
            @RequestParam("grant_type") String grantType) throws Apiunauthorized {

        validator.validate(paramMap, grantType);

        return ResponseEntity.ok(authService.login(paramMap.getFirst("client_id"), paramMap.getFirst("client_secret")));

    }
}
