package com.pajeuhub.backend.core.usecases.user;

import java.util.Map;

import com.pajeuhub.backend.core.gateway.UserGateway;

public class LoginCaseImpl implements LoginCase {

    private final UserGateway userGateway;

    public LoginCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public Map<String, Object> execute(String login, String password) {
        return userGateway.login(login, password);
    }
    
}
