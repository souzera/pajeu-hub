package com.pajeuhub.backend.infra.gateway;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.User;
import com.pajeuhub.backend.core.enums.UserRole;
import com.pajeuhub.backend.core.gateway.UserGateway;
import com.pajeuhub.backend.infra.mapper.UserMapper;
import com.pajeuhub.backend.infra.persistence.user.UserEntity;
import com.pajeuhub.backend.infra.persistence.user.UserRepository;
import com.pajeuhub.backend.infra.service.BCryptService;
import com.pajeuhub.backend.infra.service.TokenService;

@Component  
public class UserRepositoryGateway implements UserGateway{

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final BCryptService cryptoService;

    public UserRepositoryGateway(
        UserMapper userMapper,
        UserRepository userRepository,
        TokenService tokenService,
        BCryptService cryptoService
    ) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.cryptoService = cryptoService;
    }

    @Override
    public User createUser(User user) {

        User userWithEncryptedPassword = new User(
            null,
            user.login(),
            cryptoService.hash(user.password()),
            UserRole.USER
        );

        UserEntity userEntity = userMapper.toEntity(userWithEncryptedPassword);
        
        UserEntity savedUserEntity = userRepository.save(userEntity);

        return userMapper.toDomain(savedUserEntity);
    }

    @Override
    public Map<String, String> login(String login, String password) {

        UserEntity userEntity = userRepository.findByLogin(login);
        System.out.println("UserEntity: " + userEntity.getLogin());

        return Map.of("token", tokenService.generateToken(password));
    }
    
}
