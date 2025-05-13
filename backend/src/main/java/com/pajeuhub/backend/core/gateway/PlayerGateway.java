package com.pajeuhub.backend.core.gateway;

import com.pajeuhub.backend.core.entities.Player;

public interface PlayerGateway {
    
    Player createPlayer(Player player);
    Player findPlayerById(Long id);
}
