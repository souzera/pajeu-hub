package com.pajeuhub.backend.infra.dto;

import java.util.Date;
import java.util.List;


public record ActivityDTO(
    Long id,
    String info,
    Date date,
    PlaceDTO place,
    PlayerDTO creator,
    SportDTO sport,
    List<PlayerDTO> members,
    boolean status
) {}
