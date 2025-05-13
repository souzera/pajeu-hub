package com.pajeuhub.backend.core.gateway;

import com.pajeuhub.backend.core.entities.Sport;

public interface SportGateway {
    
    Sport createSport(Sport sport);
    Sport findSportById(Long id);
}
