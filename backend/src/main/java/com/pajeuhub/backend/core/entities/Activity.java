package com.pajeuhub.backend.core.entities;

import java.util.Date;

public record Activity(
    String id,
    String info,
    Date date,
    Place place,
    Player creator,
    Sport sport,
    Player[] members,
    boolean status
) {}
