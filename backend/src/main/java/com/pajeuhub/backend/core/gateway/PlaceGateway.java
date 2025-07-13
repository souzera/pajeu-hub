package com.pajeuhub.backend.core.gateway;

import java.util.List;

import com.pajeuhub.backend.core.entities.Place;

public interface PlaceGateway {

    List<Place> listPlaces();
    Place createPlace(Place place);
    Place findPlaceById(Long id);
    Place updatePlace(Place place);
    void deletePlace(Long id);
}   