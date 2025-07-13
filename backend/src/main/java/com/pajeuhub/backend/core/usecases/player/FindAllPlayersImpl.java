package com.pajeuhub.backend.core.usecases.player;

import com.pajeuhub.backend.core.entities.Player;
import com.pajeuhub.backend.core.gateway.PlayerGateway;

public class FindAllPlayersImpl implements FindAllPlayersCase {
    
    private final PlayerGateway playerGateway;

    public FindAllPlayersImpl(PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }

    @Override
    public Iterable<Player> execute() {
        return playerGateway.findAllPlayers();
    }
}
