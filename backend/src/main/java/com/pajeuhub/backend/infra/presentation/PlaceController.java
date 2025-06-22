package com.pajeuhub.backend.infra.presentation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pajeuhub.backend.core.entities.Place;
import com.pajeuhub.backend.infra.dto.PlaceDTO;
import com.pajeuhub.backend.infra.mapper.PlaceMapper;
import com.pajeuhub.backend.core.usecases.place.*;


@RestController
@RequestMapping("api/v1/places")
public class PlaceController {

    private final ListPlacesCase listPlacesCase;
    private final CreatePlaceCase createPlaceCase;
    private final FindPlaceCase findPlaceCase;

    private final PlaceMapper placeMapper;

    public PlaceController(ListPlacesCase listPlacesCase,
                           CreatePlaceCase createPlaceCase,
                           FindPlaceCase findPlaceCase) {
        this.listPlacesCase = listPlacesCase;
        this.createPlaceCase = createPlaceCase;
        this.findPlaceCase = findPlaceCase;

        this.placeMapper = new PlaceMapper();
    }

    @GetMapping
    public List<PlaceDTO> listPlaces() {
        return listPlacesCase.execute().stream().map(placeMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public String createPlace(
        @RequestBody
        Place place
    ){
        return createPlaceCase.execute(place).id().toString();
    }

    @GetMapping("/{id}")
    public PlaceDTO findPlaceById(
        Long id
    ){
        Place place = findPlaceCase.execute(id);
        return placeMapper.toDTO(place);
    }

}
