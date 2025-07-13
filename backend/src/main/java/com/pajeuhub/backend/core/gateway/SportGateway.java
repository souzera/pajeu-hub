package com.pajeuhub.backend.core.gateway;

import com.pajeuhub.backend.core.entities.Sport;

public interface SportGateway {
    
    Iterable<Sport> findAllSports();
    Sport createSport(Sport sport);
    Sport findSportById(Long id);
    Sport updateSport(Sport sport);
    void deleteSport(Long id);
}
