package com.cashflow.backend.infrastructure.security;

import org.springframework.stereotype.Component;

import com.cashflow.backend.application.usuario.GeneradorToken;

@Component
public class JwtGeneradorToken implements GeneradorToken {
    
    private final JwtService jwtService;

    public JwtGeneradorToken(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public String generar(String username) {
        return jwtService.generarToken(username);
    }
}
