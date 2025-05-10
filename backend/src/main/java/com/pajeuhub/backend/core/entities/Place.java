package com.pajeuhub.backend.core.entities;

import com.pajeuhub.backend.core.enums.PlaceType;

public record Place(
    String id,
    String address,
    String city,
    String cep,
    boolean status,
    // This is the type of place (private, public, etc.)
    PlaceType kind
) {}
