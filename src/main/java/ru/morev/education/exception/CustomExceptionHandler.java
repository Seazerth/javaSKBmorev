package ru.morev.education.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleException(Exception ex) {
        return Map.of(
                "status", "502",
                "error", "Bad Gateway",
                "message", ex.getMessage()
        );
    }
}