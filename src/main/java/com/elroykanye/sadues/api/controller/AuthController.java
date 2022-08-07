package com.elroykanye.sadues.api.controller;

import com.elroykanye.sadues.api.dto.UserDto;
import com.elroykanye.sadues.api.dto.response.SaResponse;
import com.elroykanye.sadues.business.service.i.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "/register")
    public ResponseEntity<SaResponse> register(@Valid @RequestBody UserDto.UserRegister userRegister) {
        log.info("Registering user {}", userRegister.email());
        return ResponseEntity.ok(authService.register(userRegister));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<SaResponse> login(@Valid @RequestBody UserDto.UserLogin userLogin, HttpSession httpSession) {
        try {
            return ResponseEntity.ok(authService.login(userLogin, httpSession));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(
                    new SaResponse(userLogin.email(), "Incorrect username or password"),
                    HttpStatus.UNAUTHORIZED
            );
        }
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<SaResponse> logout(@Valid @RequestBody UserDto.UserLogin userLogin, HttpSession httpSession) {
        return ResponseEntity.ok().build();
    }
}
