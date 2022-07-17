package com.elroykanye.sadues.api.controller;


import com.elroykanye.sadues.business.service.AssociationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/assoc")
public class AssociationController {
    private final AssociationService associationService;
}
