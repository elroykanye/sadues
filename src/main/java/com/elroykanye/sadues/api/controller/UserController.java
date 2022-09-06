package com.elroykanye.sadues.api.controller;


import com.elroykanye.sadues.api.dto.UserDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.service.i.UserService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<SaResponse> create(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.create(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getDto(id));
    }

    @GetMapping("/user")
    public ResponseEntity<UserDto> get(@RequestParam String email) {
        return ResponseEntity.ok(userService.getDtoByEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAllDto());
    }

    @PutMapping
    public ResponseEntity<SaResponse> update(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.update(userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        return null;
    }
}
