package com.pajeuhub.backend.infra.mapper;

import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.Place;
import com.pajeuhub.backend.infra.dto.PlaceDTO;
import com.pajeuhub.backend.infra.persistence.place.PlaceEntity;

@Component
public class PlaceMapper {
    
    public PlaceDTO toDTO(Place place){
        return new PlaceDTO(place.id(), place.address(), place.city(), place.cep(), place.status(), place.kind());
    }

    public PlaceDTO toDTO(PlaceEntity placeEntity){
        return new PlaceDTO(placeEntity.getId(), placeEntity.getAddress(), placeEntity.getCity(), placeEntity.getCep(), placeEntity.isStatus(), placeEntity.getKind());
    }

    public Place toDomain(PlaceDTO placeDTO){
        return new Place(placeDTO.id(), placeDTO.address(), placeDTO.city(), placeDTO.cep(), placeDTO.status(), placeDTO.kind());
    }

    public Place toDomain(PlaceEntity placeEntity){
        return new Place(placeEntity.getId(), placeEntity.getAddress(), placeEntity.getCity(), placeEntity.getCep(), placeEntity.isStatus(), placeEntity.getKind());
    }

    public PlaceEntity toEntity(Place place){
        return new PlaceEntity(place.id(), place.address(), place.city(), place.cep(), place.status(), place.kind());
    }

    public PlaceEntity toEntity(PlaceDTO placeDTO){
        return new PlaceEntity(placeDTO.id(), placeDTO.address(), placeDTO.city(), placeDTO.cep(), placeDTO.status(), placeDTO.kind());
    }
    
}
