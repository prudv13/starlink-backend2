package com.Hack.Hackthon.Service;

import com.Hack.Hackthon.DTO.LoginRequestDto;
import com.Hack.Hackthon.DTO.LoginResponseDto;
import com.Hack.Hackthon.DTO.RegistrationDto;
import com.Hack.Hackthon.DTO.ResponseJason;
import com.Hack.Hackthon.Dao.RegistrationRepository;
import com.Hack.Hackthon.Entity.Authority;
import com.Hack.Hackthon.Entity.RegistrationForm;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;
    public ResponseEntity<ResponseJason> addVendor(RegistrationDto registrationDto) {

        RegistrationForm registrationForm = new RegistrationForm();
        ModelMapper modelMapper = new ModelMapper();

          if(registrationRepository.existsByEmail(registrationDto.getEmail())){

              return ResponseEntity.badRequest().body(new ResponseJason(FALSE,"Username Already Exists please register with different Email Id",null));

          }else if(registrationRepository.existsByPhoneNumber(registrationDto.getPhoneNumber())){

              return ResponseEntity.badRequest().body(new ResponseJason(FALSE,"Phone number  exists,please register with  different PhoneNumber",null));


          }else{


            modelMapper.map(registrationDto ,registrationForm);
            Authority authority = new Authority();
            authority.setRoleName("VENDOR");
            registrationForm.setRoleName(authority.getRoleName());
            registrationForm.getRoles().add(authority);

            registrationRepository.save(registrationForm);

              return  ResponseEntity.ok(new ResponseJason(TRUE,"Successfully registered",registrationForm));

        }



    }


    public ResponseEntity<ResponseJason>  addCustomer(RegistrationDto registrationDto) {

        System.out.println("I am in Service");

        RegistrationForm registrationForm = new RegistrationForm();
        LoginResponseDto loginresponse = new LoginResponseDto();
        ModelMapper modelMapper = new ModelMapper();
         if(registrationRepository.existsByEmail(registrationDto.getEmail())){

             return ResponseEntity.badRequest().body(new ResponseJason(FALSE,"Username Already Exists please register with different Email Id",null));

        }else if(registrationRepository.existsByPhoneNumber(registrationDto.getPhoneNumber())){

             return ResponseEntity.badRequest().body(new ResponseJason(FALSE,"Phone number  exists,please register with  different PhoneNumber",null));

        }else{

            modelMapper.map(registrationDto ,registrationForm);

            Authority authority = new Authority();
            authority.setRoleName("CUSTOMER");
            registrationForm.setRoleName(authority.getRoleName());
            registrationForm.getRoles().add(authority);


            registrationRepository.save(registrationForm);

            modelMapper.map(registrationForm,loginresponse);

            return ResponseEntity.ok(new ResponseJason(TRUE,"Successfully registered",registrationForm));
        }
}


    public ResponseEntity<LoginResponseDto> login(LoginRequestDto loginRequestDto) {


        RegistrationForm registrationForm = registrationRepository.findByEmail(loginRequestDto.getEmail());

        System.out.println(registrationForm.getEmail());


        if (registrationForm == null) {

            return new ResponseEntity("Please  Enter valid Email", HttpStatus.BAD_REQUEST);
        } else if (registrationForm.getEmail().equals(loginRequestDto.getEmail())) {

            return ResponseEntity.ok().body(new LoginResponseDto(registrationForm.getId(), registrationForm.getFirstName(), registrationForm.getLastName(), registrationForm.getRoleName(), registrationForm.getEmail()));
           }
        return ResponseEntity.ok().body(new LoginResponseDto(registrationForm.getId(), registrationForm.getFirstName(), registrationForm.getLastName(), registrationForm.getRoleName(), registrationForm.getEmail()));
    }
}

