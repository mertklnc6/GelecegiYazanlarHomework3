package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.AuthenticationService;
import com.turkcell.rentacar.business.abstracts.UserService;
import com.turkcell.rentacar.business.dtos.requests.authentication.LoginRequest;
import com.turkcell.rentacar.core.security.services.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticationsManager implements AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public String login(LoginRequest request) {
        return null;
    }
}
