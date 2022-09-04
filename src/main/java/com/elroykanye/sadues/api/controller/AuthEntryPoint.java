package com.elroykanye.sadues.api.controller;

import com.elroykanye.sadues.api.dto.response.ExceptionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class AuthEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                authException.getMessage(),
                request.getServletPath(),
                List.of("User is not logged in")
        );
        var mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), exceptionResponse);
    }
}
