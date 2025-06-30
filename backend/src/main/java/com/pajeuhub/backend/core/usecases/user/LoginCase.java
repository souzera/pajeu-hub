package com.pajeuhub.backend.core.usecases.user;

import java.util.Map;

public interface LoginCase {
    
    /**
     * This method is used to login a user.
     *
     * @param login the login of the user
     * @param password the password of the user
     * @return token jwt
     */
    public Map<String, String> execute(String login, String password);
}
