package com.elroykanye.sadues.api.controller;

import com.elroykanye.sadues.business.service.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/university")
public class UniversityController {
    private final UniversityService universityService;
}
