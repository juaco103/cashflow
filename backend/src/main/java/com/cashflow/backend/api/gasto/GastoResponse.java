package com.cashflow.backend.api.gasto;

import com.cashflow.backend.domain.gasto.EstadoGasto;
import com.cashflow.backend.domain.gasto.Gasto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class GastoResponse {
    private final Long id;
    private final String descripcion;
    private final BigDecimal valor;
    private final BigDecimal montoPagado;
    private final BigDecimal pendiente;
    private final EstadoGasto estado;
    private final LocalDate fechaVencimiento;
    private final LocalDateTime fechaCreacion;

    public GastoResponse(Gasto gasto) {
        this.id = gasto.getId();
        this.descripcion = gasto.getDescripcion();
        this.valor = gasto.getValor();
        this.montoPagado = gasto.getMontoPagado();
        this.pendiente = gasto.getPendiente();
        this.estado = gasto.getEstado();
        this.fechaVencimiento = gasto.getFechaVencimiento();
        this.fechaCreacion = gasto.getFechaCreacion();
    }

    public Long getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public BigDecimal getValor() { return valor; }
    public BigDecimal getMontoPagado() { return montoPagado; }
    public BigDecimal getPendiente() { return pendiente; }
    public EstadoGasto getEstado() { return estado; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }    
}
