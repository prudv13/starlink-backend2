package com.Hack.Hackthon.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    private long id;

    private String firstName;

    private String lastName;

    private  String roleName;

    private String email;




}
