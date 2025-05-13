package com.pajeuhub.backend.infra.mapper;

import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.Sport;
import com.pajeuhub.backend.infra.dto.SportDTO;
import com.pajeuhub.backend.infra.persistence.sport.SportEntity;

@Component
public class SportMapper {
    
    public SportDTO toDTO(Sport sport){
        return new SportDTO(sport.id(), sport.name(), sport.description(), sport.status());
    }

    public SportDTO toDTO(SportEntity sportEntity){
        return new SportDTO(sportEntity.getId(), sportEntity.getName(), sportEntity.getDescription(), sportEntity.isStatus());
    }

    public Sport toDomain(SportDTO sportDTO){
        return new Sport(sportDTO.id(), sportDTO.name(), sportDTO.description(), sportDTO.status());
    }

    public Sport toDomain(SportEntity sportEntity){
        return new Sport(sportEntity.getId(), sportEntity.getName(), sportEntity.getDescription(), sportEntity.isStatus());
    }

    public SportEntity toEntity(Sport sport){
        return new SportEntity(sport.id(), sport.name(), sport.description(), sport.status());
    }

    public SportEntity toEntity(SportDTO sportDTO){
        return new SportEntity(sportDTO.id(), sportDTO.name(), sportDTO.description(), sportDTO.status());
    }
}
