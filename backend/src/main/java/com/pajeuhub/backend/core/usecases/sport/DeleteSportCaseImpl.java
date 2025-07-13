package com.pajeuhub.backend.core.usecases.sport;

import com.pajeuhub.backend.core.gateway.SportGateway;

public class DeleteSportCaseImpl implements DeleteSportCase {

    private final SportGateway sportGateway;

    public DeleteSportCaseImpl(SportGateway sportGateway) {
        this.sportGateway = sportGateway;
    }

    @Override
    public void execute(Long id) {
        sportGateway.deleteSport(id);
    }
    
}
