package com.pajeuhub.backend.core.gateway;

import com.pajeuhub.backend.core.entities.Activity;

public interface ActivityGateway {
    
    Activity createActivity(Activity activity);
    Activity findActivityById(Long id);
}
