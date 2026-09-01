package com.cashflow.backend.application.resumen;

import com.cashflow.backend.application.gasto.GastoRepository;
import com.cashflow.backend.application.ingreso.IngresoRepository;
import com.cashflow.backend.domain.gasto.Gasto;
import com.cashflow.backend.domain.ingreso.Ingreso;

import java.math.BigDecimal;

public class ResumenService {

    private final GastoRepository gastoRepository;
    private final IngresoRepository ingresoRepository;
    
    public ResumenService(GastoRepository gastoRepository, IngresoRepository ingresoRepository) {
        this.gastoRepository = gastoRepository;
        this.ingresoRepository = ingresoRepository;
    }
    
    public Resumen calcularResumen() {
        BigDecimal totalIngresos = ingresoRepository.listarTodos().stream()
                .map(Ingreso::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalGastos = BigDecimal.ZERO;
        BigDecimal totalPendiente = BigDecimal.ZERO;
        for (Gasto gasto : gastoRepository.listarTodos()) {
            totalGastos = totalGastos.add(gasto.getValor());
            totalPendiente = totalPendiente.add(gasto.getPendiente());
        }

        BigDecimal saldoDisponible = totalIngresos.subtract(totalGastos);

        return new Resumen(totalIngresos, totalGastos, totalPendiente, saldoDisponible);
    }    
}
