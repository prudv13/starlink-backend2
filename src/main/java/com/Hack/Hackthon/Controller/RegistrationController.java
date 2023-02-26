package com.Hack.Hackthon.Controller;


import com.Hack.Hackthon.DTO.LoginRequestDto;
import com.Hack.Hackthon.DTO.LoginResponseDto;
import com.Hack.Hackthon.DTO.RegistrationDto;
import com.Hack.Hackthon.DTO.ResponseJason;
import com.Hack.Hackthon.Dao.RegistrationRepository;
import com.Hack.Hackthon.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;


//import static java.lang.Boolean.TRUE;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    private RegistrationRepository registrationRepository;


    @PostMapping("/sign-up/vendor")
    public ResponseEntity<ResponseJason>  addVendor(@RequestBody  RegistrationDto registrationDto){

                   System.out.println("I am in controller");
        return registrationService.addVendor(registrationDto);

    }


    @PostMapping("/sign-up/customer")
    public ResponseEntity<ResponseJason> addCustomer(@RequestBody  RegistrationDto registrationDto){


          return registrationService.addCustomer(registrationDto);



    }





    @PostMapping ("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto)

    {
        System.out.println("I am in controller");
          return   registrationService.login(loginRequestDto);
    }




}
