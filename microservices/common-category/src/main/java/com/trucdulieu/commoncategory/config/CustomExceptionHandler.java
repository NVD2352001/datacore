package com.trucdulieu.commoncategory.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.trucdulieu.commoncategory.base.ResponseObject;


@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> exceptionHandler(RuntimeException e, WebRequest request) {
//        ResponseObject message = new ResponseObject(e.getCause().getLocalizedMessage());
        ResponseObject message = new ResponseObject(e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
//        return ResponseEntity.status(403).body(message);
    }
}
