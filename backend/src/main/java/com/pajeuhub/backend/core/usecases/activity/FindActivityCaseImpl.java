package com.pajeuhub.backend.core.usecases.activity;

import com.pajeuhub.backend.core.entities.Activity;
import com.pajeuhub.backend.core.gateway.ActivityGateway;

public class FindActivityCaseImpl implements FindActivityCase{

    private final ActivityGateway activityGateway;

    public FindActivityCaseImpl(ActivityGateway activityGateway) {
        this.activityGateway = activityGateway;
    }
    
    @Override
    public Activity execute(Long id) {
        return activityGateway.findActivityById(id);
    }

}
