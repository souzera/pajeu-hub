package com.pajeuhub.backend.core.usecases.sport;

import com.pajeuhub.backend.core.entities.Sport;
import com.pajeuhub.backend.core.gateway.SportGateway;

public class CreateSportCaseImpl implements CreateSportCase {

    private final SportGateway sportGateway;

    public CreateSportCaseImpl(SportGateway sportGateway){
        this.sportGateway = sportGateway;
    }

    @Override
    public Sport execute(Sport sport) {
        return sportGateway.createSport(sport);
    }

}
