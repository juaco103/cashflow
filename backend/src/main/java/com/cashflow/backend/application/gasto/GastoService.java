package com.cashflow.backend.application.gasto;

import com.cashflow.backend.domain.gasto.Gasto;

import java.util.List;

public class GastoService {
    
    private final GastoRepository gastoRepository;

    public GastoService(GastoRepository gastoRepository) {
        this.gastoRepository = gastoRepository;
    }

    public Gasto registrarGasto(Gasto gasto) {
        return gastoRepository.guardar(gasto);
    }

    public List<Gasto> listarGastos() {
        return gastoRepository.listarTodos();
    }
}
