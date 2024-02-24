package com.s19d2.securityapps.controller;

import com.s19d2.securityapps.dto.RegistrationMember;
import com.s19d2.securityapps.dto.RegistrationResponse;
import com.s19d2.securityapps.entity.Member;
import com.s19d2.securityapps.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthControler {

    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public RegistrationResponse register(@RequestBody RegistrationMember registrationMember){

        Member createdMember= authenticationService.register(registrationMember.email(), registrationMember.password());

        return new RegistrationResponse(createdMember.getEmail(), "Kayit basariyla gerceklesti");
    }

}
