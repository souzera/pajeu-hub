package com.pajeuhub.backend.core.gateway;

import java.util.List;

import com.pajeuhub.backend.core.entities.Activity;

public interface ActivityGateway {
    
    List<Activity> listActivities();
    Activity createActivity(Activity activity);
    Activity findActivityById(Long id);
    Activity updateActivity(Activity activity);
    void deleteActivity(Long id);
}
