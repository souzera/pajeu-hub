package com.pajeuhub.backend.infra.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pajeuhub.backend.core.usecases.activity.*;
import com.pajeuhub.backend.core.usecases.place.*;
import com.pajeuhub.backend.core.usecases.player.*;
import com.pajeuhub.backend.core.usecases.sport.*;
import com.pajeuhub.backend.core.usecases.user.*;

import com.pajeuhub.backend.core.gateway.*;

@Configuration
public class BeanConfiguration {

    // ACTIVITY

    @Bean
    public CreateActivityCase createActivityCase(ActivityGateway activityGateway) {
        return new CreateActivityCaseImpl(activityGateway);
    }

    // PLACE

    @Bean
    public CreatePlaceCase createPlaceCase(PlaceGateway placeGateway){
        return new CreatePlaceCaseImpl(placeGateway);
    }

    // SPORT

    @Bean
    public CreateSportCase createSportCase(SportGateway sportGateway){
        return new CreateSportCaseImpl(sportGateway);
    }

    // PLAYER
    
    @Bean
    public CreatePlayerCase createPlayerCase(PlayerGateway playerGateway) {
        return new CreatePlayerCaseImpl(playerGateway);
    }

    // USER
    
    @Bean
    public CreateUserCase createUserCase(UserGateway userGateway) {
        return new CreateUserCaseImpl(userGateway);
    }
}
