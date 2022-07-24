package com.elroykanye.sadues.api.controller;


import com.elroykanye.sadues.api.dto.ExecutiveDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.service.i.ExecutiveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping(value = "/api/executive")
public class ExecutiveController {
    private final ExecutiveService executiveService;

    @PostMapping
    public ResponseEntity<SaResponse> create(ExecutiveDto executiveDto) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExecutiveDto> get(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<ExecutiveDto>> getAll() {
        return null;
    }

    @PutMapping
    public ResponseEntity<SaResponse> update(ExecutiveDto executiveDto) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return null;
    }
}
