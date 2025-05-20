package com.pajeuhub.backend.core.gateway;

import com.pajeuhub.backend.core.entities.User;

public interface UserGateway {
    
    User createUser(User user);
    String login(String login, String password);
}
