package com.houses.inmobiliary.web.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.houses.inmobiliary.domain.exceptions.HouseAlreadyExists;
import com.houses.inmobiliary.domain.exceptions.HouseNotFoundException;

@RestControllerAdvice
public class HouseExceptionHandler {

    @ExceptionHandler(HouseNotFoundException.class)
    public ResponseEntity<Error> handleHouseNotFoundException(HouseNotFoundException ex) {
        Error error = new Error("NOT_FOUND", ex.getMessage());
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(error);
    }

    @ExceptionHandler(HouseAlreadyExists.class)
    public ResponseEntity<Error> handleHouseAlreadyExists(HouseAlreadyExists ex) {
        Error error = new Error("CONFLICT", ex.getMessage());
        return ResponseEntity.status(HttpStatusCode.valueOf(409)).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(Exception ex) {
        Error error = new Error("INTERNAL_SERVER_ERROR", ex.getMessage());
        return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(error);
    }
    
}
