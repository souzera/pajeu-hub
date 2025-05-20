package com.pajeuhub.backend.core.usecases.player;

import com.pajeuhub.backend.core.entities.Player;
import com.pajeuhub.backend.core.gateway.PlayerGateway;

public class CreatePlayerCaseImpl implements CreatePlayerCase {

    private final PlayerGateway playerGateway;

    public CreatePlayerCaseImpl(PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }
    
    @Override
    public Player execute(Player player) {
        return playerGateway.createPlayer(player);
    }

}