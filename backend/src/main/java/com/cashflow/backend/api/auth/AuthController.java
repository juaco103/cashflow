package com.cashflow.backend.api.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cashflow.backend.application.usuario.AutenticacionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final AutenticacionService autenticacionService;
    
    public AuthController(AutenticacionService autenticacionService) {
        this.autenticacionService = autenticacionService;
    }
    
    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        String token = autenticacionService.login(request.getUsername(), request.getPassword());
        return new LoginResponse(token);
    }    
}
