package com.cashflow.backend.application.ingreso;

import com.cashflow.backend.domain.ingreso.Ingreso;

import java.util.List;

public class IngresoService {

    private final IngresoRepository ingresoRepository;

    public IngresoService(IngresoRepository ingresoRepository) {
        this.ingresoRepository = ingresoRepository;
    }
    
    public Ingreso registrarIngreso(Ingreso ingreso) {
        return ingresoRepository.guardar(ingreso);
    }
    
    public List<Ingreso> listarIngresos() {
        return ingresoRepository.listarTodos();
    }    
}
