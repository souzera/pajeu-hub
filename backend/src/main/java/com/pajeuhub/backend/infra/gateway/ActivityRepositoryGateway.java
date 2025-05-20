package com.pajeuhub.backend.infra.gateway;

import org.springframework.stereotype.Component;

import com.pajeuhub.backend.core.entities.Activity;
import com.pajeuhub.backend.core.gateway.ActivityGateway;
import com.pajeuhub.backend.infra.mapper.ActivityMapper;
import com.pajeuhub.backend.infra.persistence.activity.ActivityEntity;
import com.pajeuhub.backend.infra.persistence.activity.ActivityRepository;

@Component
public class ActivityRepositoryGateway implements ActivityGateway{

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;

    public ActivityRepositoryGateway(
        ActivityRepository activityRepository,
        ActivityMapper activityMapper
    ) {
        this.activityRepository = activityRepository;
        this.activityMapper = activityMapper;
    }

    @Override
    public Activity createActivity(Activity activity) {
        ActivityEntity activityEntity = activityMapper.toEntity(activity);
        ActivityEntity savedActivityEntity = activityRepository.save(activityEntity);

        return activityMapper.toDomain(savedActivityEntity);
    }

    @Override
    public Activity findActivityById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findActivityById'");
    } 
    

    
}
