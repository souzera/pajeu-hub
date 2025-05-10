package com.pajeuhub.backend.core.usecases;

import com.pajeuhub.backend.core.entities.Activity;

public interface CreateActivityCase {
    
    public Activity execute(Activity activity);
}
