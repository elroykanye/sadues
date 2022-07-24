package com.elroykanye.sadues.api.controller;


import com.elroykanye.sadues.api.dto.AcademicYearDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.service.i.AcademicYearService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/academic_year")
public class AcademicYearController {
    private final AcademicYearService academicYearService;

    @PostMapping
    public ResponseEntity<SaResponse> create(AcademicYearDto academicYearDto) {
        log.info("Creating academic year {}", academicYearDto.name());
        return new ResponseEntity<>(academicYearService.create(academicYearDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicYearDto> get(@PathVariable("id") Long id) {
        log.info("Getting DTO for academic year of id: {}", id);
        return ResponseEntity.ok(academicYearService.getDto(id));
    }

    @GetMapping
    public ResponseEntity<List<AcademicYearDto>> getAll() {
        log.info("Getting DTOs for all academic years");
        return ResponseEntity.ok(academicYearService.getAllDto());
    }

    @PutMapping
    public ResponseEntity<SaResponse> update(AcademicYearDto academicYearDto) {
        log.info("Updating academic year of id: {}", academicYearDto.id());
        return ResponseEntity.ok(academicYearService.update(academicYearDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        log.info("Deleting academic year of id: {}", id);
        academicYearService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
