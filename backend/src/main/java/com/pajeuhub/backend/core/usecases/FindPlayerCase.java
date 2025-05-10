package com.pajeuhub.backend.core.usecases;

import com.pajeuhub.backend.core.entities.Player;

public interface FindPlayerCase {
    
    public Player execute(String id);
    
}
