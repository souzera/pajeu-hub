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
import com.pajeuhub.backend.infra.validation.UserValidation;

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
    public ResponseEntity<Map<String, String>> login(
        @RequestBody
        LoginDTO userDto
    ){
        if (!(UserValidation.loginValidation(userDto))){
            return ResponseEntity.badRequest().body(Map.of("message", "Invalid login data"));
        }
        User user = userMapper.toDomain(userDto);
        return ResponseEntity.ok(loginCase.execute(user.login(), user.password()));
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createUser(
        @RequestBody
        RegisterDTO userDTO
    ){
        if (!(UserValidation.registerValidation(userDTO))){
            return ResponseEntity.badRequest().body(Map.of("message", "Invalid registration data"));
        }

        // verify if user already exists

        User user = createUserCase.execute(userMapper.toDomain(userDTO));

        Map<String, Object> response = new HashMap<>();
        response.put("message", "User created successfully");
        response.put("user", userMapper.toDTO(user));

        return ResponseEntity.ok(response);
    }

    
}
