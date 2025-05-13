package com.pajeuhub.backend.infra.dto;

public record UserDTO(
    Long id,
    String login,
    String password
){
}
