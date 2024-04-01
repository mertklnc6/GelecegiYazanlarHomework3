package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.user.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register(RegisterRequest request);
}
