package com.pajeuhub.backend.infra.dto;

public record SportDTO(
    Long id,
    String name,
    String description,
    boolean status
) {}
