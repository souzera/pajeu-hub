package com.pajeuhub.backend.infra.mapper;

import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.User;
import com.pajeuhub.backend.core.enums.UserRole;
import com.pajeuhub.backend.infra.dto.UserDTO;
import com.pajeuhub.backend.infra.persistence.user.UserEntity;

@Component
public class UserMapper {
    
    public UserDTO toDTO(User user){
        return new UserDTO(user.id(), user.login(), user.password(), user.role() != null ? user.role().name() : UserRole.USER.name());
    }

    public UserDTO toDTO(UserEntity userEntity){
        return new UserDTO(userEntity.getId(), userEntity.getLogin(), userEntity.getPassword(), 
                           userEntity.getRole() != null ? userEntity.getRole().name() : UserRole.USER.name());
    }

    public User toDomain(UserDTO userDTO){
        return new User(userDTO.id(), userDTO.login(), userDTO.password(), 
                        userDTO.role() != null ? UserRole.valueOf(userDTO.role()) : UserRole.USER);
    }

    public User toDomain(UserEntity userEntity){
        return new User(userEntity.getId(), userEntity.getLogin(), userEntity.getPassword(), 
                        userEntity.getRole() != null ? UserRole.valueOf(userEntity.getRole().name()) : UserRole.USER);
    }

    public UserEntity toEntity(User user){
        return new UserEntity(user.id(), user.login(), user.password(), 
                              user.role() != null ? user.role() : UserRole.USER);
    }

    public UserEntity toEntity(UserDTO userDTO){
        return new UserEntity(userDTO.id(), userDTO.login(), userDTO.password(), 
                              userDTO.role() != null ? UserRole.valueOf(userDTO.role()) : UserRole.USER);
    }

}
