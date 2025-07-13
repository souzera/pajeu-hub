package com.pajeuhub.backend.core.usecases.sport;

import com.pajeuhub.backend.core.entities.Sport;
import com.pajeuhub.backend.core.gateway.SportGateway;

public class UpdateSportCaseImpl implements UpdateSportCase{

    private final SportGateway sportGateway;

    public UpdateSportCaseImpl(SportGateway sportGateway) {
        this.sportGateway = sportGateway;
    }

    @Override
    public Sport execute(Sport sport) {
        return sportGateway.updateSport(sport);
    }
    
}
