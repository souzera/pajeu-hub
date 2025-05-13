package com.pajeuhub.backend.infra.dto;

import com.pajeuhub.backend.core.enums.PlaceType;

public record PlaceDTO(
        Long id,
        String address,
        String city,
        String cep,
        boolean status,
        PlaceType kind
) {}