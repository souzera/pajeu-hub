package com.pajeuhub.backend.core.gateway;

import com.pajeuhub.backend.core.entities.Place;

public interface PlaceGateway {

    Place createPlace(Place place);
    Place findPlaceById(Long id);
}   