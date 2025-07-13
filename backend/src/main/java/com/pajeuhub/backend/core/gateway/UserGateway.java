package com.pajeuhub.backend.core.gateway;

import java.util.Map;

import com.pajeuhub.backend.core.entities.User;

public interface UserGateway {
    
    User createUser(User user);
    Map<String, Object> login(String login, String password);

    void deleteUser(Long id);
}
