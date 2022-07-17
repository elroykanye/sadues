package com.elroykanye.sadues.api.controller;


import com.elroykanye.sadues.business.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/student")
public class StudentController {
    private final StudentService studentService;
}
