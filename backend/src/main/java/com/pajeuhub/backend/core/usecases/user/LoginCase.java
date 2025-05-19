package com.pajeuhub.backend.core.usecases.user;

public interface LoginCase {
    
    /**
     * This method is used to login a user.
     *
     * @param login the login of the user
     * @param password the password of the user
     * @return token jwt
     */
    public String execute(String login, String password);
}
