package com.pajeuhub.backend.core.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;


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
    // public Activity(Long id, String info, Date date, Place place, Player creator, Sport sport, List<Player> members, boolean status) {
    //     this.id = id;
    //     this.info = info;
    //     this.date = date;
    //     this.place = place;
    //     this.creator = creator;
    //     this.sport = sport;
    //     this.members = members;
    //     this.status = status;
    // }
}
