package com.elroykanye.sadues.api.controller;

import com.elroykanye.sadues.api.dto.UniversityDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.service.i.UniversityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j // TODO add logging
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/university")
public class UniversityController {
    private final UniversityService universityService;

    @PostMapping
    public ResponseEntity<SaResponse> create(@Valid @RequestBody UniversityDto universityDto) {
        return new ResponseEntity<>(universityService.create(universityDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityDto> get(@NotNull @PathVariable("id") Long id) {
        return ResponseEntity.ok(universityService.getDto(id));
    }

    @GetMapping
    public ResponseEntity<List<UniversityDto>> getAll() {
        return ResponseEntity.ok(universityService.getAllDto());
    }

    @PutMapping
    public ResponseEntity<SaResponse> update(@Valid @RequestBody UniversityDto universityDto) {
        return ResponseEntity.ok(universityService.update(universityDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        universityService.delete(id);
        return ResponseEntity.ok().build();
    }
}
