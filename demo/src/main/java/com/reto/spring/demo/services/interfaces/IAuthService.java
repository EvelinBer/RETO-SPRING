package com.reto.spring.demo.services.interfaces;

import com.reto.spring.demo.dtos.AuthResponse;
import com.reto.spring.demo.dtos.LoginRequest;

public interface IAuthService {
    AuthResponse login(LoginRequest loginRequest);
}
