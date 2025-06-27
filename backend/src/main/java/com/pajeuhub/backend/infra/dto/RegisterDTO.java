package com.pajeuhub.backend.infra.dto;

public record RegisterDTO(
    String email,
    String password,
    String confirmPassword
) {    
}
