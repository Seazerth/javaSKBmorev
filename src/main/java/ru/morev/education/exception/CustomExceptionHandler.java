package ru.morev.education.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> handleIllegalArg(IllegalArgumentException ex) {
        return Map.of(
                "status", "400",
                "error", "Bad Request",
                "message", ex.getMessage()
        );
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleUnknown(Exception ex) {
        return Map.of(
                "status", "500",
                "error", "Internal Server Error",
                "message", ex.getMessage()
        );
    }
}
