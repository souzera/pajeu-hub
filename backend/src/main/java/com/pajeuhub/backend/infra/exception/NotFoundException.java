package com.pajeuhub.backend.infra.exception;

import java.util.Map;

public class NotFoundException extends RuntimeException {

    public static Map<String, Object> notFoundException(){
        return Map.of("error", "not found exception");
    }
    
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
    
}
