package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.AuthenticationService;
import com.turkcell.rentacar.business.dtos.requests.authentication.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authService;


    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request)
    {
        return authService.login(request);
    }
}