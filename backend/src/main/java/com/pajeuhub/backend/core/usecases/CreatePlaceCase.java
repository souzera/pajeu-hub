package com.pajeuhub.backend.core.usecases;

import com.pajeuhub.backend.core.entities.Place;

public interface CreatePlaceCase {

    public Place execute(Place place);

}
