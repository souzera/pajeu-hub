package com.pajeuhub.backend.infra.presentation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pajeuhub.backend.core.entities.User;
import com.pajeuhub.backend.core.usecases.user.CreateUserCase;
import com.pajeuhub.backend.core.usecases.user.LoginCase;
import com.pajeuhub.backend.infra.dto.LoginDTO;
import com.pajeuhub.backend.infra.dto.RegisterDTO;
//import com.pajeuhub.backend.infra.dto.UserDTO;
import com.pajeuhub.backend.infra.mapper.UserMapper;

import com.pajeuhub.backend.infra.service.TokenService;

@RestController
public class UserController {
    

    private final UserMapper userMapper;

    private final CreateUserCase createUserCase;
    private final LoginCase loginCase;

    public UserController(
        CreateUserCase createUserCase,
        LoginCase loginCase,
        TokenService tokenService
    ){
        this.userMapper = new UserMapper();

        this.createUserCase = createUserCase;
        this.loginCase = loginCase;
    }

    @PostMapping("/login")
    public String login(
        @RequestBody
        LoginDTO userDto
    ){
        User user = userMapper.toDomain(userDto);
        return loginCase.execute(user.login(), user.password());
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createUser(
        @RequestBody
        RegisterDTO userDTO
    ){
        // TODO: validate reguest method

        if (userDTO.password().equals(userDTO.confirmPassword())){
            return ResponseEntity.badRequest().body(Map.of("message", "Passwords do not match"));
        };

        if (userDTO.email() == null || userDTO.password() == null || userDTO.confirmPassword() == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email and password are required"));
        }

        // verify if user already exists

        User user = createUserCase.execute(userMapper.toDomain(userDTO));

        Map<String, Object> response = new HashMap<>();
        response.put("message", "User created successfully");
        response.put("user", userMapper.toDTO(user));

        return ResponseEntity.ok(response);
    }

    
}
