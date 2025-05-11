package com.pajeuhub.backend.infra.dto;

import java.util.Date;


public record ActivityDTO(
    Long id,
    String info,
    Date date,
    PlaceDTO place,
    PlayerDTO creator,
    SportDTO sport,
    PlayerDTO[] members
) {}
