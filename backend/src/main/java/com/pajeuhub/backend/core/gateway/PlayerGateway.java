package com.pajeuhub.backend.core.gateway;

import com.pajeuhub.backend.core.entities.Player;

public interface PlayerGateway {
    
    Iterable<Player> findAllPlayers();
    Player createPlayer(Player player);
    Player findPlayerById(Long id);
    Player updatePlayer(Player player);
    void deletePlayer(Long id);
}
