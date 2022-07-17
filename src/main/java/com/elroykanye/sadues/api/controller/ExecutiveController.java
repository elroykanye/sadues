package com.elroykanye.sadues.api.controller;


import com.elroykanye.sadues.business.service.ExecutiveService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/executive")
public class ExecutiveController {
    private final ExecutiveService executiveService;
}
