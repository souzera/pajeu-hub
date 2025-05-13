package com.pajeuhub.backend.core.entities;

import java.util.Date;
import java.util.List;

public record Activity(
    Long id,
    String info,
    Date date,
    Place place,
    Player creator,
    Sport sport,
    List<Player> members,
    boolean status
) {
}
