package com.pajeuhub.backend.infra.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pajeuhub.backend.core.entities.Place;

@RestController
@RequestMapping("api/v1/places")
public class PlaceController {

    @PostMapping
    public String createPlace(
        @RequestBody
        Place place
    ){
        return "create place";
    }


}
