package com.cashflow.backend.api.ingreso;

import com.cashflow.backend.domain.ingreso.Ingreso;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class IngresoResponse {
    
    private final Long id;
    private final String descripcion;
    private final BigDecimal valor;
    private final LocalDate fecha;
    private final LocalDateTime fechaCreacion;

    public IngresoResponse(Ingreso ingreso) {
        this.id = ingreso.getId();
        this.descripcion = ingreso.getDescripcion();
        this.valor = ingreso.getValor();
        this.fecha = ingreso.getFecha();
        this.fechaCreacion = ingreso.getFechaCreacion();
    }

    public Long getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public BigDecimal getValor() { return valor; }
    public LocalDate getFecha() { return fecha; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }    
}
