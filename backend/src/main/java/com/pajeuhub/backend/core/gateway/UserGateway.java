package com.pajeuhub.backend.core.gateway;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public interface UserGateway {
    
    User createUser(User user);
    boolean login(String login, String password);
}
