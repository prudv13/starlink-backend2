package com.Hack.Hackthon.DTO;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {

    private long id;
    private String firstname;
    private String lastname;
    private String  phoneNumber;
    private String email;
    private String password;
    private  String roleName;
}
