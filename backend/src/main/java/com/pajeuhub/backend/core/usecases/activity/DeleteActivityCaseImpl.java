package com.pajeuhub.backend.core.usecases.activity;

import com.pajeuhub.backend.core.gateway.ActivityGateway;

public class DeleteActivityCaseImpl implements DeleteActivityCase {
    
    private final ActivityGateway activityGateway;

    public DeleteActivityCaseImpl(ActivityGateway activityGateway) {
        this.activityGateway = activityGateway;
    }

    @Override
    public void execute(Long id) {
        activityGateway.deleteActivity(id);
    }
}
