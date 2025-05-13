package com.pajeuhub.backend.infra.mapper;

import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.User;
import com.pajeuhub.backend.infra.dto.UserDTO;
import com.pajeuhub.backend.infra.persistence.user.UserEntity;

@Component
public class UserMapper {
    
    public UserDTO toDTO(User user){
        return new UserDTO(user.id(), user.login(), user.password());
    }

    public UserDTO toDTO(UserEntity userEntity){
        return new UserDTO(userEntity.getId(), userEntity.getLogin(), userEntity.getPassword());
    }

    public User toDomain(UserDTO userDTO){
        return new User(userDTO.id(), userDTO.login(), userDTO.password());
    }

    public User toDomain(UserEntity userEntity){
        return new User(userEntity.getId(), userEntity.getLogin(), userEntity.getPassword());
    }

    public UserEntity toEntity(User user){
        return new UserEntity(user.id(), user.login(), user.password());
    }

    public UserEntity toEntity(UserDTO userDTO){
        return new UserEntity(userDTO.id(), userDTO.login(), userDTO.password());
    }
}
