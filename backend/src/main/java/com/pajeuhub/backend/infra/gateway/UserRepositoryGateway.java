package com.pajeuhub.backend.infra.gateway;

import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.User;
import com.pajeuhub.backend.core.gateway.UserGateway;
import com.pajeuhub.backend.infra.mapper.UserMapper;
import com.pajeuhub.backend.infra.persistence.user.UserEntity;
import com.pajeuhub.backend.infra.persistence.user.UserRepository;
import com.pajeuhub.backend.infra.service.TokenService;

@Component  
public class UserRepositoryGateway implements UserGateway{

    private final UserMapper userMapper;
    private final UserRepository userRepository;
     private final TokenService tokenService;

    public UserRepositoryGateway(
        UserMapper userMapper,
        UserRepository userRepository,
        TokenService tokenService
    ) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
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

        UserEntity userEntity = userRepository.findByLogin(login);
        System.out.println("UserEntity: " + userEntity.getLogin());

        return tokenService.generateToken(userMapper.toDomain(userEntity).login() + "" + userMapper.toDomain(userEntity).password());
    }
    
}
