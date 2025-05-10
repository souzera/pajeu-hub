package com.pajeuhub.backend.core.usecases.user;

public interface LoginCase {
    
    /**
     * This method is used to login a user.
     *
     * @param login the login of the user
     * @param password the password of the user
     * @return a boolean indicating the result of the login attempt
     */
    public boolean execute(String login, String password);
}
