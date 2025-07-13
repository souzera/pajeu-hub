package com.pajeuhub.backend.core.usecases.sport;

import com.pajeuhub.backend.core.entities.Sport;
import com.pajeuhub.backend.core.gateway.SportGateway;

public class FindAllSportsCaseImpl implements FindAllSportsCase {

    private final SportGateway sportGateway;

    public FindAllSportsCaseImpl(SportGateway sportGateway) {
        this.sportGateway = sportGateway;
    }

    @Override
    public Iterable<Sport> execute() {
        return sportGateway.findAllSports();
    }
    
}
