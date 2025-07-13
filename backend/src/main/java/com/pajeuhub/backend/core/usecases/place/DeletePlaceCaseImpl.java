package com.pajeuhub.backend.core.usecases.place;

import com.pajeuhub.backend.core.gateway.PlaceGateway;

public class DeletePlaceCaseImpl implements DeletePlaceCase {
    
    private final PlaceGateway placeGateway;

    public DeletePlaceCaseImpl(PlaceGateway placeGateway) {
        this.placeGateway = placeGateway;
    }

    @Override
    public void execute(Long id) {
        placeGateway.deletePlace(id);
    }
}
