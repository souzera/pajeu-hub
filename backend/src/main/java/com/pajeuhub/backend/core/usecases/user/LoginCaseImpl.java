package com.pajeuhub.backend.core.usecases.user;

import com.pajeuhub.backend.core.gateway.UserGateway;

public class LoginCaseImpl implements LoginCase {

    private final UserGateway userGateway;

    public LoginCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public String execute(String login, String password) {
        return userGateway.login(login, password);
    }
    
}
