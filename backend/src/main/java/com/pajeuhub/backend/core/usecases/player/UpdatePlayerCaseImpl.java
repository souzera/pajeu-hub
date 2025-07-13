package com.pajeuhub.backend.core.usecases.player;

import com.pajeuhub.backend.core.entities.Player;
import com.pajeuhub.backend.core.gateway.PlayerGateway;

public class UpdatePlayerCaseImpl implements UpdatePlayerCase {
    
    private final PlayerGateway playerGateway;

    public UpdatePlayerCaseImpl(PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }

    @Override
    public Player execute(Player player) {
        return playerGateway.updatePlayer(player);
    }
}
