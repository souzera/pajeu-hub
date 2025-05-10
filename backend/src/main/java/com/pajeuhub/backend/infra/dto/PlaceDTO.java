package com.pajeuhub.backend.infra.dto;

public record PlaceDTO(
        Long id,
        String address,
        String city,
        String cep,
        boolean status,
        String kind
) {}