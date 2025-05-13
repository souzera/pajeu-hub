package com.pajeuhub.backend.infra.presentation;

import java.util.Map;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pajeuhub.backend.core.entities.Activity;
import com.pajeuhub.backend.core.usecases.activity.CreateActivityCase;
import com.pajeuhub.backend.core.usecases.activity.FindActivityCase;
import com.pajeuhub.backend.infra.dto.ActivityDTO;
import com.pajeuhub.backend.infra.mapper.ActivityMapper;

@RestController
@RequestMapping("api/v1/activities")
public class ActivityController {

    private final ActivityMapper activityMapper;

    private final CreateActivityCase createActivityCase;
    private final FindActivityCase findActivityCase;

    public ActivityController(
        CreateActivityCase createActivityCase,
        FindActivityCase findActivityCase
    ) {
        this.activityMapper = new ActivityMapper();

        this.createActivityCase = createActivityCase;
        this.findActivityCase = findActivityCase;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createActivity(
        @RequestBody
        ActivityDTO activityDTO
    ) {
        Activity activity = createActivityCase.execute(activityMapper.toDomain(activityDTO));

        Map<String, Object> response = new HashMap<>();

        response.put("message", "Activity created successfully");
        response.put("activity", activityMapper.toDTO(activity));

        return ResponseEntity.ok(response);
    }
}
