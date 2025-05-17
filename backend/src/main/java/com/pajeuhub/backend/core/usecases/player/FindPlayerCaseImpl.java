package com.pajeuhub.backend.core.usecases.player;

import com.pajeuhub.backend.core.entities.Player;
import com.pajeuhub.backend.core.gateway.PlayerGateway;

public class FindPlayerCaseImpl implements FindPlayerCase {

    private final PlayerGateway playerGateway;

    public FindPlayerCaseImpl(PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }

    @Override
    public Player execute(Long id) {
        return  playerGateway.findPlayerById(id);
    }
}
