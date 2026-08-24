package com.cashflow.backend.application.gasto;

import com.cashflow.backend.domain.gasto.Gasto;

import java.util.List;

public interface GastoRepository {
    Gasto guardar(Gasto gasto);
    List<Gasto> listarTodos();
}
