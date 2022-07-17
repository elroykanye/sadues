package com.elroykanye.sadues.api.controller;


import com.elroykanye.sadues.business.service.AcademicYearService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/academicyear")
public class AcademicYearController {
    private final AcademicYearService academicYearService;

}
