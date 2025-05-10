package com.pajeuhub.backend.core.usecases.sport;

import com.pajeuhub.backend.core.entities.Sport;

public class CreateSportCaseImpl implements CreateSportCase {

    @Override
    public Sport execute(Sport sport) {
        return sport;
    }

}
