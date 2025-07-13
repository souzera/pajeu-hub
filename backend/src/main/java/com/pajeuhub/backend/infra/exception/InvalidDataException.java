package com.pajeuhub.backend.infra.exception;

import java.util.Map;

public class InvalidDataException extends RuntimeException{

    public static Map<String, Object> data(){
        return Map.of("error", "invalid data");
    }

    public static Map<String, Object> data(String param){
        return Map.of("error", "param " + param + "invalid");
    }

    public static Map<String, Object> dataWithCustomMessage(String message){
        return Map.of("error", message);
    }

    public InvalidDataException(String message){
        super(message);
    }

    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDataException(Throwable cause) {
        super(cause);
    }
}
