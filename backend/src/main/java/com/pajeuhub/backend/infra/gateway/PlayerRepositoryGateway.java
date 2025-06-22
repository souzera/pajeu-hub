package com.pajeuhub.backend.infra.gateway;

import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.Player;
import com.pajeuhub.backend.core.gateway.PlayerGateway;
import com.pajeuhub.backend.infra.mapper.PlayerMapper;
import com.pajeuhub.backend.infra.persistence.player.PlayerEntity;
import com.pajeuhub.backend.infra.persistence.player.PlayerRepository;

@Component
public class PlayerRepositoryGateway implements PlayerGateway{

    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;

    public PlayerRepositoryGateway(
        PlayerMapper playerMapper,
        PlayerRepository playerRepository
    ) {
        this.playerMapper = playerMapper;
        this.playerRepository = playerRepository;
    }

    @Override
    public Player createPlayer(Player player) {
        PlayerEntity playerEntity = playerMapper.toEntity(player);
        PlayerEntity savedPlayerEntity = playerRepository.save(playerEntity);

        return playerMapper.toDomain(savedPlayerEntity);
    }

    @Override
    public Player findPlayerById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPlayerById'");
    }
    
}
