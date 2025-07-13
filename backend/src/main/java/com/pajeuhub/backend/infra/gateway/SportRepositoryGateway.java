package com.pajeuhub.backend.infra.gateway;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.Sport;
import com.pajeuhub.backend.core.gateway.SportGateway;
import com.pajeuhub.backend.infra.exception.NotFoundException;
import com.pajeuhub.backend.infra.mapper.SportMapper;
import com.pajeuhub.backend.infra.persistence.sport.SportEntity;
import com.pajeuhub.backend.infra.persistence.sport.SportRepository;

@Component
public class SportRepositoryGateway implements SportGateway{

    private final SportMapper sportMapper;
    private final SportRepository sportRepository;

    public SportRepositoryGateway(
        SportMapper sportMapper,
        SportRepository sportRepository
    ) {
        this.sportMapper = sportMapper;
        this.sportRepository = sportRepository;
    }

    @Override
    public Sport createSport(Sport sport) {
        SportEntity sportEntity = sportMapper.toEntity(sport);
        SportEntity savedSportEntity = sportRepository.save(sportEntity);

        return sportMapper.toDomain(savedSportEntity);
    }

    @Override
    public Sport findSportById(Long id) {
        try{
            Optional<SportEntity> sportEntity = sportRepository.findById(id);
            Sport sport = sportMapper.toDomain(sportEntity.get());
            return sport;
        } catch (NotFoundException exception){
            throw new NotFoundException("sport not found");
        }
    }

    @Override
    public Iterable<Sport> findAllSports() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllSports'");
    }

    @Override
    public Sport updateSport(Sport sport) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSport'");
    }

    @Override
    public void deleteSport(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSport'");
    }

    
    
}
