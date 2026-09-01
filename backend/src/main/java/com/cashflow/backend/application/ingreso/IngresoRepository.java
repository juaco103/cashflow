package com.cashflow.backend.application.ingreso;

import com.cashflow.backend.domain.ingreso.Ingreso;

import java.util.List;

public interface IngresoRepository {
    Ingreso guardar(Ingreso ingreso);
    List<Ingreso> listarTodos();   
}
