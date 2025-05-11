package com.pajeuhub.backend.infra.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sports")
public class SportController {
    
    @PostMapping
    public String createSport() {
        return "create sport";
    }
}
