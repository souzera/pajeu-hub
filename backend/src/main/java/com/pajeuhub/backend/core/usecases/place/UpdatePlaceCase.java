package com.pajeuhub.backend.core.usecases.place;

import com.pajeuhub.backend.core.entities.Place;

public interface UpdatePlaceCase {
    Place execute(Place place);
}
