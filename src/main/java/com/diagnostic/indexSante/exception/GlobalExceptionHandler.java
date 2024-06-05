package com.diagnostic.indexSante.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.diagnostic.indexSante.model.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ErrorHandler.class)
    public ResponseEntity<?> handleMissingParameterException(ErrorHandler ex) {
        ApiResponse<String> response = new ApiResponse<>(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
