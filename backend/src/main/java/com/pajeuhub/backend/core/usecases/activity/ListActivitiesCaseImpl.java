package com.pajeuhub.backend.core.usecases.activity;

import java.util.List;

import com.pajeuhub.backend.core.entities.Activity;
import com.pajeuhub.backend.core.gateway.ActivityGateway;

public class ListActivitiesCaseImpl implements ListActivitiesCase {
    
    private final ActivityGateway activityGateway;

    public ListActivitiesCaseImpl(ActivityGateway activityGateway) {
        this.activityGateway = activityGateway;
    }

    @Override
    public List<Activity> execute() {
        return activityGateway.listActivities();
    }
}
