package com.company.mt.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @since 1.0
 * Class is used to override default messages for Spring validation annotations
 */
@ControllerAdvice
public class ValidationHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected ResponseEntity<List<Map<String, String>>> validationExceptionHandler(MethodArgumentNotValidException ex) {

        List<FieldError> fieldErrors = ex.getBindingResult()
                .getFieldErrors();

        List<Map<String, String>> response = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {
            String fieldErrorMessage = fieldError.getDefaultMessage() != null ? fieldError.getDefaultMessage() : "Field is empty or null!";
            response.add(Map.of("field", fieldError.getField(), "error", fieldErrorMessage));
        }

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}