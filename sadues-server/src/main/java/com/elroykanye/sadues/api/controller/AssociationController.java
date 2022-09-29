package com.elroykanye.sadues.api.controller;


import com.elroykanye.sadues.api.dto.AssociationDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.service.i.AssociationService;
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
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/assoc")
public class AssociationController {
    private final AssociationService associationService;

    @PostMapping
    public ResponseEntity<SaResponse> create(@Valid @RequestBody AssociationDto associationDto) {
        log.info("Creating association with name: {}", associationDto.name());
        return new ResponseEntity<>(associationService.create(associationDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociationDto> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(associationService.getDto(id));
    }

    @GetMapping("/uni/{universityId}")
    public ResponseEntity<List<AssociationDto>> getByUniversity(@PathVariable Long universityId) {
        return ResponseEntity.ok(associationService.getAllDtoByUniversity(universityId));
    }


    @GetMapping
    public ResponseEntity<List<AssociationDto>> getAll() {
        return ResponseEntity.ok(associationService.getAllDto());
    }

    @PutMapping
    public ResponseEntity<SaResponse> update(@Valid @RequestBody AssociationDto associationDto) {
        return ResponseEntity.ok(associationService.update(associationDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        associationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
