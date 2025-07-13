package com.pajeuhub.backend.core.usecases.activity;

import com.pajeuhub.backend.core.entities.Activity;
import com.pajeuhub.backend.core.gateway.ActivityGateway;

public class UpdateActivityCaseImpl implements UpdateActivityCase {
    private final ActivityGateway activityGateway;

    public UpdateActivityCaseImpl(ActivityGateway activityGateway) {
        this.activityGateway = activityGateway;
    }

    @Override
    public Activity execute(Activity activity) {
        return activityGateway.updateActivity(activity);
    }
}
