package com.pajeuhub.backend.core.usecases.user;

import com.pajeuhub.backend.core.entities.User;

public class CreateuserCaseImpl implements CreateUserCase {
    
    @Override
    public User execute(User user) {
        return user;
    }

}
