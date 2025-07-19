package com.CURD_01.indetify_service.exception;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
        ResponseEntity<String> handleRuntimeException(RuntimeException exception){
            return ResponseEntity
                    .badRequest()
                    .body( exception.getMessage());
        }
    @ExceptionHandler(value = Exception.class)
        ResponseEntity<String> handleValidation(MethodArgumentNotValidException exception){
            return ResponseEntity
                    .badRequest()
                    .body( exception.getFieldError().getDefaultMessage());
        }
}
