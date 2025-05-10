package com.pajeuhub.backend.core.entities;

public record Player(
    Long id,
    String name,
    String contact,
    User user
) {}
