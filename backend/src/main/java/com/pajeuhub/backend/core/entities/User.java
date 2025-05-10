package com.pajeuhub.backend.core.entities;

public record User(
    Long id,
    String login,
    String password
) {}
