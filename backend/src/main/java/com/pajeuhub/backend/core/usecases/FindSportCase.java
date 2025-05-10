package com.pajeuhub.backend.core.usecases;

import com.pajeuhub.backend.core.entities.Sport;

public interface FindSportCase {
    public Sport execute(String id);
}
