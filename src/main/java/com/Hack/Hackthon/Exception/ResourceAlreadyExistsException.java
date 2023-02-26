package com.Hack.Hackthon.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ResourceAlreadyExistsException  extends RuntimeException {





    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<String> ResourceAlreadyExistsException() {

        return new ResponseEntity<String>("Phone number  exists,please register with  different PhoneNumber", HttpStatus.BAD_REQUEST);
    }
}
