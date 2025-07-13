package com.pajeuhub.backend.core.usecases.activity;

import java.util.List;

import com.pajeuhub.backend.core.entities.Activity;

public interface ListActivitiesCase {
    List<Activity> execute();
}
