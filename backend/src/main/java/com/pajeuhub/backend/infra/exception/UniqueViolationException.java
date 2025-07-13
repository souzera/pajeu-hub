package com.pajeuhub.backend.infra.exception;

import java.util.Map;

public class UniqueViolationException extends RuntimeException{

    public static Map<String, Object> data(){
        return Map.of("error", "unique violation exception");
    }

    public static Map<String, Object> data(String param){
        return Map.of("error", "param " + param + " violated the unique value constraint");
    }
    
    public UniqueViolationException(String message) {
        super(message);
    }

    public UniqueViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniqueViolationException(Throwable cause) {
        super(cause);
    }
}
