package com.pajeuhub.backend.core.usecases.place;

import java.util.List;

import com.pajeuhub.backend.core.entities.Place;
import com.pajeuhub.backend.core.gateway.PlaceGateway;

public class ListPlacesCaseImpl implements ListPlacesCase {

    private final PlaceGateway placeGateway;

    public ListPlacesCaseImpl(PlaceGateway placeGateway) {
        this.placeGateway = placeGateway;
    }

    @Override
    public List<Place> execute() {
        return placeGateway.listPlaces(); 
    }
    
}
