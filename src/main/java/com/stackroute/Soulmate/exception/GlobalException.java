package com.stackroute.Soulmate.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @Value(value = "${data.exception.msg1}")
    private String msg1;

    @Value(value = "${data.exception.msg2}")
    private String msg2;

    @ExceptionHandler(value = SoulmateNotFoundException.class)
    public ResponseEntity<String> notFound(SoulmateNotFoundException soulmateNotFoundException){
        return new ResponseEntity<>(msg1 , HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = SoulmateAlreadyExistException.class)
    public ResponseEntity<String> notFound(SoulmateAlreadyExistException soulmateAlreadyExistException){
        return new ResponseEntity<>(msg2 , HttpStatus.CONFLICT);
    }
}
