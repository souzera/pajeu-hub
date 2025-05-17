package com.pajeuhub.backend.core.usecases.sport;

import com.pajeuhub.backend.core.entities.Sport;

public interface FindSportCase {
    public Sport execute(Long id);
}
