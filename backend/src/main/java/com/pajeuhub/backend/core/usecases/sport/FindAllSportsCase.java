package com.pajeuhub.backend.core.usecases.sport;

import com.pajeuhub.backend.core.entities.Sport;

public interface FindAllSportsCase {
    
    Iterable<Sport> execute();
}
