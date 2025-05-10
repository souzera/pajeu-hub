package com.pajeuhub.backend.core.usecases.sport;

import com.pajeuhub.backend.core.entities.Sport;

public interface CreateSportCase {
    public Sport execute(Sport sport);
}
