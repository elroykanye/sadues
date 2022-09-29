package com.elroykanye.sadues.exception;


import com.elroykanye.sadues.api.dto.response.ExceptionResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @NotNull
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(@NotNull HttpRequestMethodNotSupportedException ex, @NotNull HttpHeaders headers, @NotNull HttpStatus status, @NotNull WebRequest request) {
        return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
    }

    @NotNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @NotNull HttpHeaders headers, @NotNull HttpStatus status, @NotNull WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(
                new ExceptionResponse("Validation failed for field(s) in request",
                request.getDescription(false), errors), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    protected ResponseEntity<ExceptionResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest webRequest) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(
                new ExceptionResponse("This action is causing a conflict on the database", webRequest.getDescription(false), null),
                HttpStatus.CONFLICT
        );
    }


    @ExceptionHandler(value = {NoSuchElementException.class})
    protected ResponseEntity<ExceptionResponse> handleNoSuchElementException(NoSuchElementException ex, WebRequest webRequest) {
        logger.error(ex.getMessage());
        return new ResponseEntity<>(
                new ExceptionResponse(ex.getMessage(), webRequest.getDescription(false), null),
                HttpStatus.NOT_FOUND
        );
    }
}
