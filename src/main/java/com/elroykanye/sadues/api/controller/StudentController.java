package com.elroykanye.sadues.api.controller;


import com.elroykanye.sadues.api.dto.StudentDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.service.StudentService;
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
@RequestMapping(value = "/api/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<SaResponse> create(StudentDto studentDto) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> get(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() {
        return null;
    }

    @PutMapping
    public ResponseEntity<SaResponse> update(StudentDto studentDto) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return null;
    }
}
