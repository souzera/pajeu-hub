package com.pajeuhub.backend.infra.dto;

public record RegisterDTO(
    String login,
    String password,
    String confirmPassword
) {    
}
