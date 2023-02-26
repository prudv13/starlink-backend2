package com.Hack.Hackthon.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseJason {

    private boolean status;
    private String message;
    private Object object;


}
