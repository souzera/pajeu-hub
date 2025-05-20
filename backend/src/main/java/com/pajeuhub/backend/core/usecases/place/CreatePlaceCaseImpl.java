package com.pajeuhub.backend.core.usecases.place;

import com.pajeuhub.backend.core.entities.Place;
import com.pajeuhub.backend.core.gateway.PlaceGateway;

public class CreatePlaceCaseImpl implements CreatePlaceCase{

    private final PlaceGateway placeGateway;

    public CreatePlaceCaseImpl(PlaceGateway placeGateway) {
        this.placeGateway = placeGateway;
    }

    @Override
    public Place execute(Place place) {
        return placeGateway.createPlace(place);
    }
    
}
