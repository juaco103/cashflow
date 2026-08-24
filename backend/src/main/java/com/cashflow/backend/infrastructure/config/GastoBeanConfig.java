package com.cashflow.backend.infrastructure.config;

import com.cashflow.backend.application.gasto.GastoRepository;
import com.cashflow.backend.application.gasto.GastoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GastoBeanConfig {

    @Bean
    public GastoService gastoService(GastoRepository gastoRepository) {
        return new GastoService(gastoRepository);
    }
}