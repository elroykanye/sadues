package com.elroykanye.sadues.api.controller;

import com.elroykanye.sadues.api.dto.AcademicYearDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.service.UniversityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/university")
public class UniversityController {
    private final UniversityService universityService;

    @PostMapping
    public ResponseEntity<SaResponse> create(AcademicYearDto academicYearDto) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicYearDto> get(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<AcademicYearDto>> getAll() {
        return null;
    }

    @PutMapping
    public ResponseEntity<SaResponse> update(AcademicYearDto academicYearDto) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return null;
    }
}
