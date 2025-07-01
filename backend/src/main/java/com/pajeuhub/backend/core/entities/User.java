package com.pajeuhub.backend.core.entities;

import com.pajeuhub.backend.core.enums.UserRole;

public record User(
    Long id,
    String login,
    String password,
    UserRole role
) {}
