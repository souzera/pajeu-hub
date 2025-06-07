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

    @Bean FindActivityCase findActivityCase(ActivityGateway activityGateway) {
        return new FindActivityCaseImpl(activityGateway);
    }

    // PLACE

    @Bean
    public CreatePlaceCase createPlaceCase(PlaceGateway placeGateway){
        return new CreatePlaceCaseImpl(placeGateway);
    }

    @Bean
    public FindPlaceCase findPlaceCase(PlaceGateway placeGateway) {
        return new FindPlaceCaseImpl(placeGateway);
    }

    // SPORT

    @Bean
    public CreateSportCase createSportCase(SportGateway sportGateway){
        return new CreateSportCaseImpl(sportGateway);
    }

    @Bean
    public FindSportCase findSportCase(SportGateway sportGateway) {
        return new FindSportCaseImpl(sportGateway);
    }

    // PLAYER
    
    @Bean
    public CreatePlayerCase createPlayerCase(PlayerGateway playerGateway) {
        return new CreatePlayerCaseImpl(playerGateway);
    }

    @Bean
    public FindPlayerCase findPlayerCase(PlayerGateway playerGateway) {
        return new FindPlayerCaseImpl(playerGateway);
    }

    // USER
    
    @Bean
    public CreateUserCase createUserCase(UserGateway userGateway) {
        return new CreateUserCaseImpl(userGateway);
    }

    @Bean
    public LoginCase loginCase(UserGateway userGateway) {
        return new LoginCaseImpl(userGateway);
    }
}
