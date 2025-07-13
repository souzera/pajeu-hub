package com.pajeuhub.backend.core.usecases.activity;

import com.pajeuhub.backend.core.entities.Activity;

public interface UpdateActivityCase {
    
    Activity execute(Activity activity);
}
