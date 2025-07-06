package com.pajeuhub.backend.infra.gateway;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.User;
import com.pajeuhub.backend.core.enums.UserRole;
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

    private final AuthenticationManager authenticationManager;

    public UserRepositoryGateway(
        UserMapper userMapper,
        UserRepository userRepository,
        TokenService tokenService,
        AuthenticationManager authenticationManager
    ) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public User createUser(User user) {

        User userWithEncryptedPassword = new User(
            null,
            user.login(),
            user.password(),
            UserRole.USER
        );

        UserEntity userEntity = userMapper.toEntity(userWithEncryptedPassword);
        
        UserEntity savedUserEntity = userRepository.save(userEntity);

        return userMapper.toDomain(savedUserEntity);
    }

    @Override
    public Map<String, String> login(String login, String password) {

        var user = new UsernamePasswordAuthenticationToken(login, password);

        var auth = authenticationManager.authenticate(user);

        var token = tokenService.generateToken(auth.getPrincipal().toString());

        return Map.of("token", token);
    }
    
}
