package com.pajeuhub.backend.core.usecases.user;

import java.util.Map;

public interface LoginCase {
    
    public Map<String, Object> execute(String login, String password);
}
