package com.pajeuhub.backend.core.usecases.player;

import com.pajeuhub.backend.core.gateway.PlayerGateway;

public class DeletePlayerCaseImpl implements DeletePlayerCase {
    
    private final PlayerGateway playerGateway;

    public DeletePlayerCaseImpl(PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }

    @Override
    public void execute(Long id) {
        playerGateway.deletePlayer(id);
    }
}
