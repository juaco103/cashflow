package com.cashflow.backend.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cashflow.backend.application.usuario.AutenticacionService;
import com.cashflow.backend.application.usuario.CodificadorContrasena;
import com.cashflow.backend.application.usuario.GeneradorToken;
import com.cashflow.backend.application.usuario.UsuarioRepository;

@Configuration
public class AutenticacionBeanConfig {

    @Bean
    public AutenticacionService autenticacionService(UsuarioRepository usuarioRepository,
                                                       CodificadorContrasena codificadorContrasena,
                                                       GeneradorToken generadorToken) {
        return new AutenticacionService(usuarioRepository, codificadorContrasena, generadorToken);
    }    
}
