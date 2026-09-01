package com.cashflow.backend.infrastructure.config;

import com.cashflow.backend.application.ingreso.IngresoRepository;
import com.cashflow.backend.application.ingreso.IngresoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IngresoBeanConfig {
 
    @Bean
    public IngresoService ingresoService(IngresoRepository ingresoRepository) {
        return new IngresoService(ingresoRepository);
    }    
}
