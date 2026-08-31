package com.cashflow.backend.api.ingreso;

import com.cashflow.backend.application.ingreso.IngresoService;
import com.cashflow.backend.domain.ingreso.Ingreso;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ingresos")
public class IngresoController {

    private final IngresoService ingresoService;
    
    public IngresoController(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }
    
    @PostMapping
    public ResponseEntity<IngresoResponse> registrarIngreso(@Valid @RequestBody IngresoRequest request) {
        Ingreso ingreso = new Ingreso(null, request.getDescripcion(), request.getValor(), request.getFecha(), null);
        Ingreso guardado = ingresoService.registrarIngreso(ingreso);
        return ResponseEntity.status(HttpStatus.CREATED).body(new IngresoResponse(guardado));
    }    

    @GetMapping
    public List<IngresoResponse> listarIngresos() {
        return ingresoService.listarIngresos().stream()
                .map(IngresoResponse::new)
                .toList();
    }    
}
