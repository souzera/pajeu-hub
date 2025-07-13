package com.pajeuhub.backend.core.usecases.player;

import com.pajeuhub.backend.core.entities.Player;

public interface UpdatePlayerCase {
    Player execute(Player player);
}
