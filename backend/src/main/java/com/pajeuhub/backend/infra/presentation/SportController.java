package com.pajeuhub.backend.infra.presentation;

import java.util.Map;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pajeuhub.backend.core.entities.Sport;
import com.pajeuhub.backend.core.usecases.sport.CreateSportCase;
import com.pajeuhub.backend.core.usecases.sport.FindSportCase;
import com.pajeuhub.backend.infra.dto.SportDTO;
import com.pajeuhub.backend.infra.mapper.SportMapper;

@RestController
@RequestMapping("api/v1/sports")
public class SportController {
    
    private final SportMapper sportMapper;

    private final CreateSportCase createSportCase;
    private final FindSportCase findSportCase;

    public SportController(
        CreateSportCase createSportCase,
        FindSportCase findSportCase
    ) {
        this.sportMapper = new SportMapper();

        this.createSportCase = createSportCase;
        this.findSportCase = findSportCase;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createSport(
        @RequestBody
        SportDTO sportDTO
    ) {
        Sport sport = createSportCase.execute(sportMapper.toDomain(sportDTO));

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Sport created successfully");
        response.put("sport", sportMapper.toDTO(sport));

        return ResponseEntity.ok(response);
    }
}
