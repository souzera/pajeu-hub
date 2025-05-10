package com.pajeuhub.backend.core.usecases.user;

import com.pajeuhub.backend.core.entities.User;

public interface CreateUserCase {

    public User execute(User user);

}
