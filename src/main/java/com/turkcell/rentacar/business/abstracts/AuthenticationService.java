package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.authentication.LoginRequest;

public interface AuthenticationService {
    String login(LoginRequest request);
}
