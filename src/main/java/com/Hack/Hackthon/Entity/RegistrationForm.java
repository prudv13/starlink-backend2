package com.Hack.Hackthon.Entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class RegistrationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String  phoneNumber;
    private String email;
    private String password;
    private  String roleName;




    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "RegistrationForm_Authority",joinColumns = @JoinColumn(name ="reg_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Authority> roles = new ArrayList<>();

    public void setLoggedIn(boolean b) {


    }
}
