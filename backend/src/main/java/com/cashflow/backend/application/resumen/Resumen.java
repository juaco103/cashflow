package com.cashflow.backend.application.resumen;

import java.math.BigDecimal;

public record Resumen(
        BigDecimal totalIngresos,
        BigDecimal totalGastos,
        BigDecimal totalPendiente,
        BigDecimal saldoDisponible        
){
    
}

