package com.pajeuhub.backend.core.usecases.player;

import com.pajeuhub.backend.core.entities.Player;

public class CreatePlayerCaseImpl implements CreatePlayerCase {
    
    @Override
    public Player execute(Player player) {
        return player;
    }

}