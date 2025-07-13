package com.pajeuhub.backend.infra.validation;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.pajeuhub.backend.infra.dto.LoginDTO;
import com.pajeuhub.backend.infra.dto.RegisterDTO;
import com.pajeuhub.backend.infra.exception.InvalidDataException;
import com.pajeuhub.backend.infra.exception.UniqueViolationException;
import com.pajeuhub.backend.infra.persistence.user.UserRepository;

@Component
public class UserValidation {
    
    public static final String SUCESS_MESSAGE = "success validation";

    private final UserRepository userRepository;

    public UserValidation(
        UserRepository userRepository
    ){
        this.userRepository = userRepository;
    }

    public boolean loginValidation(LoginDTO loginDTO) {
        if  (loginDTO == null) {
            return false;
        }

        if (loginDTO.login() == null || loginDTO.password() == null) {
            return false;
        }

        if (loginDTO.login().isEmpty() || loginDTO.password().isEmpty()) {
            return false;
        }

        return true;
    }

    public Map<String, Object> registerValidation(RegisterDTO registerDTO){
        if (registerDTO == null) {
            return InvalidDataException.data();
        }

        if (registerDTO.login() == null || registerDTO.login().isEmpty()) {
            return InvalidDataException.data("login");
        }

        if (registerDTO.password() == null || registerDTO.password().isEmpty()){
            return InvalidDataException.data("password");
        }

        if (registerDTO.confirmPassword() == null || registerDTO.confirmPassword().isEmpty()) {
            return InvalidDataException.data("confirmPassword");
        }

        if (!registerDTO.password().equals(registerDTO.confirmPassword())) {
            return InvalidDataException.dataWithCustomMessage("passwords not equals");
        }

        if (userRepository.findByLogin(registerDTO.login()) != null){
            return UniqueViolationException.data(registerDTO.login());
        }

        return Map.of("sucess", SUCESS_MESSAGE);
    }
}
