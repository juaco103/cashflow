package com.cashflow.backend.infrastructure.config;

import com.cashflow.backend.application.gasto.GastoRepository;
import com.cashflow.backend.application.ingreso.IngresoRepository;
import com.cashflow.backend.application.resumen.ResumenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResumenBeanConfig {

    @Bean
    public ResumenService resumenService(GastoRepository gastoRepository, IngresoRepository ingresoRepository) {
        return new ResumenService(gastoRepository, ingresoRepository);
    }    
}
