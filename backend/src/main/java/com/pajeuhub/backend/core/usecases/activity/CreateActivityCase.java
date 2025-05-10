package com.pajeuhub.backend.core.usecases.activity;

import com.pajeuhub.backend.core.entities.Activity;

public interface CreateActivityCase {
    
    public Activity execute(Activity activity);
}
