package com.pajeuhub.backend.infra.gateway;

import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.User;
import com.pajeuhub.backend.core.gateway.UserGateway;
import com.pajeuhub.backend.infra.mapper.UserMapper;
import com.pajeuhub.backend.infra.persistence.user.UserEntity;
import com.pajeuhub.backend.infra.persistence.user.UserRepository;

@Component  
public class UserRepositoryGateway implements UserGateway{

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserRepositoryGateway(
        UserMapper userMapper,
        UserRepository userRepository
    ) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = userMapper.toEntity(user);

        // TOKEN AND CRYPT PASSWORD
        UserEntity savedUserEntity = userRepository.save(userEntity);

        return userMapper.toDomain(savedUserEntity);
    }

    @Override
    public String login(String login, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
    
}
