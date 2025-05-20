package com.pajeuhub.backend.core.usecases.user;

import com.pajeuhub.backend.core.entities.User;
import com.pajeuhub.backend.core.gateway.UserGateway;

public class CreateUserCaseImpl implements CreateUserCase {

    private final UserGateway userGateway;

    public CreateUserCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }
    
    @Override
    public User execute(User user) {
        return userGateway.createUser(user);
    }

}
