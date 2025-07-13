package com.pajeuhub.backend.core.usecases.user;

import com.pajeuhub.backend.core.gateway.UserGateway;

public class DeleteUserCaseImpl implements DeleteUserCase{
    
    private final UserGateway userGateway;

    public DeleteUserCaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void execute(Long id) {
        userGateway.deleteUser(id);
    }
}
