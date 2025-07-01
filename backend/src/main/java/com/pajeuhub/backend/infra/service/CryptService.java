package com.pajeuhub.backend.infra.service;

import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCrypt;

@Service
public class CryptService {
    
    public String hash(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean verify(String password, String hashedPassword){
        return BCrypt.checkpw(password, hashedPassword);
    }
}
