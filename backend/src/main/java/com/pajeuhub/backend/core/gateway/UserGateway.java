package com.pajeuhub.backend.core.gateway;

import java.util.Map;

import com.pajeuhub.backend.core.entities.User;

public interface UserGateway {
    
    User createUser(User user);
    Map<String, String> login(String login, String password);
}
