package com.pajeuhub.backend.core.usecases;

import com.pajeuhub.backend.core.entities.Sport;

public interface CreateSportCase {
    public Sport execute(Sport sport);
}
