package com.pajeuhub.backend.core.usecases;

import com.pajeuhub.backend.core.entities.Place;

public interface FindPlaceCase {
    
    public Place execute(String id);
    
}
