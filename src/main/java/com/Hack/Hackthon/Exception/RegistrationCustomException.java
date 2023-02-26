package com.Hack.Hackthon.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ControllerAdvice
public class RegistrationCustomException extends RuntimeException {

    private String errorCode;
    private String errorMessage;




    @ExceptionHandler(RegistrationCustomException.class)
    public ResponseEntity<String> customException() {

        System.out.println(errorCode);
        System.out.println(errorMessage);


        return new ResponseEntity<String>("Username Already Exists please register with different Email Id", HttpStatus.BAD_REQUEST);
    }

}

