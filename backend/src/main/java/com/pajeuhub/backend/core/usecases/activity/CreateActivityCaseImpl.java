package com.pajeuhub.backend.core.usecases.activity;

import com.pajeuhub.backend.core.entities.Activity;
import com.pajeuhub.backend.core.gateway.ActivityGateway;

public class CreateActivityCaseImpl implements CreateActivityCase {

    private final ActivityGateway activityGateway;

    public CreateActivityCaseImpl(ActivityGateway activityGateway) {
        this.activityGateway = activityGateway;
    }

    @Override
    public Activity execute(Activity activity) {
        return activityGateway.createActivity(activity);
    }
    
}
