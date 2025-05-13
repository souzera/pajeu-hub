package com.pajeuhub.backend.infra.mapper;

import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.Player;
import com.pajeuhub.backend.infra.dto.PlayerDTO;
import com.pajeuhub.backend.infra.persistence.player.PlayerEntity;

@Component
public class PlayerMapper {
    
    public PlayerDTO toDTO(Player player){
        return new PlayerDTO(player.id(), player.name(), player.contact(), new UserMapper().toDTO(player.user()));
    }

    public PlayerDTO toDTO(PlayerEntity playerEntity){
        return new PlayerDTO(playerEntity.getId(), playerEntity.getName(), playerEntity.getContact(), new UserMapper().toDTO(playerEntity.getUser()));
    }

    public Player toDomain(PlayerDTO playerDTO){
        return new Player(playerDTO.id(), playerDTO.name(), playerDTO.contact(), new UserMapper().toDomain(playerDTO.user()));
    }

    public Player toDomain(PlayerEntity playerEntity){
        return new Player(playerEntity.getId(), playerEntity.getName(), playerEntity.getContact(), new UserMapper().toDomain(playerEntity.getUser()));
    }

    public PlayerEntity toEntity(Player player){
        return new PlayerEntity(player.id(), player.name(), player.contact(), new UserMapper().toEntity(player.user()));
    }

    public PlayerEntity toEntity(PlayerDTO playerDTO){
        return new PlayerEntity(playerDTO.id(), playerDTO.name(), playerDTO.contact(), new UserMapper().toEntity(playerDTO.user()));
    }
}
