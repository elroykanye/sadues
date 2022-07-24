package com.elroykanye.sadues.api.exception;

import com.elroykanye.sadues.api.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ExceptionResponse> handleNoSuchElement(NoSuchElementException e, WebRequest webRequest) {
        return new ResponseEntity<>(new ExceptionResponse(e.getMessage(), webRequest.getContextPath()), HttpStatus.NOT_FOUND);
    }
}
