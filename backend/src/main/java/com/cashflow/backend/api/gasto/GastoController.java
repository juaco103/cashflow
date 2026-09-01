package com.cashflow.backend.api.gasto;

import com.cashflow.backend.application.gasto.GastoService;
import com.cashflow.backend.domain.gasto.Gasto;
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
@RequestMapping("/api/gastos")
public class GastoController {
    
    private final GastoService gastoService;

    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }    

    @PostMapping
    public ResponseEntity<GastoResponse> registrarGasto(@Valid @RequestBody GastoRequest request) {
        Gasto gasto = new Gasto(
                null,
                request.getDescripcion(),
                request.getValor(),
                request.getMontoPagado(),
                request.getFechaVencimiento(),
                null
        );
        Gasto guardado = gastoService.registrarGasto(gasto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new GastoResponse(guardado));
    }  
    
    @GetMapping
    public List<GastoResponse> listarGastos() {
        return gastoService.listarGastos().stream()
                .map(GastoResponse::new)
                .toList();
    }
}
