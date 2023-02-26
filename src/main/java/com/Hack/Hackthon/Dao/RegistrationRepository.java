package com.Hack.Hackthon.Dao;

import com.Hack.Hackthon.Entity.RegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationForm,Long> {
    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

   RegistrationForm findByEmail(String email);



}
