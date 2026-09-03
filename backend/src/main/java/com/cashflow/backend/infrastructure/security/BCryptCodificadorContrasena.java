package com.cashflow.backend.infrastructure.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cashflow.backend.application.usuario.CodificadorContrasena;

@Component
public class BCryptCodificadorContrasena implements CodificadorContrasena {

    private final PasswordEncoder passwordEncoder;

    public BCryptCodificadorContrasena(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }    

    @Override
    public boolean coincide(String contrasenaPlana, String contrasenaHasheada) {
        return passwordEncoder.matches(contrasenaPlana, contrasenaHasheada);
    }
    
}
