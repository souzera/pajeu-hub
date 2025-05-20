package com.pajeuhub.backend.core.usecases.sport;

import com.pajeuhub.backend.core.entities.Sport;
import com.pajeuhub.backend.core.gateway.SportGateway;

public class FindSportCaseImpl implements FindSportCase {

    private final SportGateway sportGateway;
    
    public FindSportCaseImpl(SportGateway sportGateway){
        this.sportGateway = sportGateway;
    }

    @Override
    public Sport execute(Long id) {
        return sportGateway.findSportById(id);
    }
}
