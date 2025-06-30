package com.pajeuhub.backend.infra.validation;

import com.pajeuhub.backend.infra.dto.LoginDTO;
import com.pajeuhub.backend.infra.dto.RegisterDTO;

public class UserValidation {
    

    public static boolean loginValidation(LoginDTO loginDTO) {
        if  (loginDTO == null) {
            return false;
        }

        if (loginDTO.email() == null || loginDTO.password() == null) {
            return false;
        }

        if (loginDTO.email().isEmpty() || loginDTO.password().isEmpty()) {
            return false;
        }

        return true;
    }

    public static boolean registerValidation(RegisterDTO registerDTO){
        if (registerDTO == null) {
            return false;
        }

        if (registerDTO.email() == null || registerDTO.password() == null || registerDTO.confirmPassword() == null) {
            return false;
        }

        if (registerDTO.email().isEmpty() || registerDTO.password().isEmpty() || registerDTO.confirmPassword().isEmpty()) {
            return false;
        }

        if (!registerDTO.password().equals(registerDTO.confirmPassword())) {
            return false;
        }

        return true;
    }
}
