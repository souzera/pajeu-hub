package com.pajeuhub.backend.infra.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class TokenService {

    private static final String SECRET = "your-secret";

    private static final long EXPIRATION_TIME = 86400000;

    public String generateToken(String text){
        try{
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                .withSubject(text)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(algorithm);
        }catch (JWTCreationException e){
            throw new RuntimeException("Error creating JWT token", e);
        }
    }
}
