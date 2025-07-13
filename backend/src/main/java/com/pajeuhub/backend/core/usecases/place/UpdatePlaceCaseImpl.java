package com.pajeuhub.backend.core.usecases.place;

import com.pajeuhub.backend.core.entities.Place;
import com.pajeuhub.backend.core.gateway.PlaceGateway;

public class UpdatePlaceCaseImpl implements UpdatePlaceCase {
    
    private final PlaceGateway placeGateway;

    public UpdatePlaceCaseImpl(PlaceGateway placeGateway) {
        this.placeGateway = placeGateway;
    }

    @Override
    public Place execute(Place place) {
        return placeGateway.updatePlace(place);
    }
}
