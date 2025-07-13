package com.pajeuhub.backend.core.usecases.player;

import com.pajeuhub.backend.core.entities.Player;

public interface FindAllPlayersCase {
    Iterable<Player> execute();
}
