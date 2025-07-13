package com.pajeuhub.backend.infra.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.Place;
import com.pajeuhub.backend.core.gateway.PlaceGateway;
import com.pajeuhub.backend.infra.mapper.PlaceMapper;
import com.pajeuhub.backend.infra.persistence.place.PlaceEntity;
import com.pajeuhub.backend.infra.persistence.place.PlaceRepository;

@Component
public class PlaceRepositoryGateway implements PlaceGateway{

    private final PlaceMapper placeMapper;
    private final PlaceRepository placeRepository;

    public PlaceRepositoryGateway(
        PlaceMapper placeMapper,
        PlaceRepository placeRepository
    ) {
        this.placeMapper = placeMapper;
        this.placeRepository = placeRepository;
    }

    @Override
    public Place createPlace(Place place) {
        PlaceEntity placeEntity = placeMapper.toEntity(place);
        PlaceEntity savedPlaceEntity = placeRepository.save(placeEntity);

        return placeMapper.toDomain(savedPlaceEntity);
    }

    @Override
    public Place findPlaceById(Long id) {
        Optional<PlaceEntity> placeEntity = placeRepository.findById(id);
        
        if (placeEntity.isPresent()){
            return placeMapper.toDomain(placeMapper.toDTO(placeEntity.get()));
        }
        return null;
    }

    @Override
    public List<Place> listPlaces() {
        List<PlaceEntity> placeEntities = placeRepository.findAll();
        return placeEntities.stream()
                            .map(placeMapper::toDomain)
                            .toList();
    }

    @Override
    public Place updatePlace(Place place) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePlace'");
    }

    @Override
    public void deletePlace(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePlace'");
    }

    
    
}
