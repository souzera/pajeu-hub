package com.pajeuhub.backend.infra.presentation;

import com.pajeuhub.backend.infra.mappers.PlayerMapper;
import com.pajeuhub.backend.core.usecases.player.CreatePlayerUseCase;
import com.pajeuhub.backend.core.usecases.player.FindPlayerUseCase;

public class PlayerController {
    
    private final PlayerMapper playerMapper;

    private final CreatePlayerUseCase createPlayerUseCase;
    private final FindPlayerUseCase findPlayerUseCase;

    public PlayerController(
        CreatePlayerUseCase createPlayerUseCase,
        FindPlayerUseCase findPlayerUseCase
    ){
        this.playerMapper = new PlayerMapper();

        this.createPlayerUseCase = createPlayerUseCase;
        this.findPlayerUseCase = findPlayerUseCase;
    }

    public ResponseEntity<Map<String, Object>> createPlayer(
        @RequestBody PlayerDTO playerDTO
    ){
        Player player = createPlayerUseCase.execute(playerMapper.toDomain(playerDTO));

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Player created successfully");
        response.put("player", playerMapper.toDTO(player));

        return ResponseEntity.ok(response);
    }
    
}
