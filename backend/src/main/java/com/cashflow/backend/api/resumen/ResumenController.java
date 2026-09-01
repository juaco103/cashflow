package com.cashflow.backend.api.resumen;

import com.cashflow.backend.application.resumen.Resumen;
import com.cashflow.backend.application.resumen.ResumenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resumen")
public class ResumenController {

    private final ResumenService resumenService;

    public ResumenController(ResumenService resumenService) {
        this.resumenService = resumenService;
    }
    
    @GetMapping
    public Resumen obtenerResumen() {
        return resumenService.calcularResumen();
    }    
}
