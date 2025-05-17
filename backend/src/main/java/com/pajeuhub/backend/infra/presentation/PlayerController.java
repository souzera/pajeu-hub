package com.pajeuhub.backend.infra.presentation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pajeuhub.backend.core.entities.Player;
import com.pajeuhub.backend.core.usecases.player.CreatePlayerCase;
import com.pajeuhub.backend.core.usecases.player.FindPlayerCase;
import com.pajeuhub.backend.infra.dto.PlayerDTO;
import com.pajeuhub.backend.infra.mapper.PlayerMapper;

@RestController
public class PlayerController {
    
    private final PlayerMapper playerMapper;

    private final CreatePlayerCase createPlayerCase;
    private final FindPlayerCase findPlayerCase;

    public PlayerController(
        CreatePlayerCase createPlayeCase,
        FindPlayerCase findPlayerCase
    ){
        this.playerMapper = new PlayerMapper();

        this.createPlayerCase = createPlayeCase;
        this.findPlayerCase = findPlayerCase;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createPlayer(
        @RequestBody PlayerDTO playerDTO
    ){
        Player player = createPlayerCase.execute(playerMapper.toDomain(playerDTO));

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Player created successfully");
        response.put("player", playerMapper.toDTO(player));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findPlayerById(
        @PathVariable("id")
        String id
    ){
        Player player = findPlayerCase.execute(id);
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Player found successfully");
        response.put("player", playerMapper.toDTO(player));

        return ResponseEntity.ok(response);
    }
    
}
