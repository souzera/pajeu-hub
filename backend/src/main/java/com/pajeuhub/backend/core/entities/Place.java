package com.pajeuhub.backend.core.entities;

import com.pajeuhub.backend.core.enums.PlaceType;

public record Place(
    Long id,
    String address,
    String city,
    String cep,
    boolean status,
    // This is the type of place (private, public, etc.)
    PlaceType kind
) {
    public Place(Long id, String address, String city, String cep, boolean status, PlaceType kind) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.cep = cep;
        this.status = status;
        this.kind = kind;
    }
}
