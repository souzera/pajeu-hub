package com.pajeuhub.backend.core.usecases.place;

import com.pajeuhub.backend.core.entities.Place;
import com.pajeuhub.backend.core.gateway.PlaceGateway;

public class FindPlaceCaseImpl implements FindPlaceCase {

    private final PlaceGateway placeGateway;

    public FindPlaceCaseImpl(PlaceGateway placeGateway) {
        this.placeGateway = placeGateway;
    }

    @Override
    public Place execute(Long id) {
        return placeGateway.findPlaceById(id);
    }
}
