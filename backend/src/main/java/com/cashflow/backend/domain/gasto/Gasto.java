package com.cashflow.backend.domain.gasto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gasto {
    
    private final Long id;
    private final String descripcion;
    private final BigDecimal valor;
    private final BigDecimal montoPagado;
    private final LocalDate fechaVencimiento;
    private final LocalDateTime fechaCreacion;

    public Gasto(Long id, String descripcion, BigDecimal valor, BigDecimal montoPagado,
                 LocalDate fechaVencimiento, LocalDateTime fechaCreacion) {
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("La descripcion es obligatoria");
        }
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El valor debe ser mayor que cero");
        }
        BigDecimal pagado = montoPagado == null ? BigDecimal.ZERO : montoPagado;
        if (pagado.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El monto pagado no puede ser negativo");
        }
        if (pagado.compareTo(valor) > 0) {
            throw new IllegalArgumentException("El monto pagado no puede superar el valor del gasto");
        }

        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
        this.montoPagado = pagado;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaCreacion = fechaCreacion == null ? LocalDateTime.now() : fechaCreacion;
    }

    public BigDecimal getPendiente() {
        return valor.subtract(montoPagado);
    }

    public EstadoGasto getEstado() {
        if (getPendiente().compareTo(BigDecimal.ZERO) == 0) {
            return EstadoGasto.PAGADO;
        }
        if (montoPagado.compareTo(BigDecimal.ZERO) > 0) {
            return EstadoGasto.PARCIALMENTE_PAGADO;
        }
        return EstadoGasto.PENDIENTE;
    }

    public Long getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public BigDecimal getValor() { return valor; }
    public BigDecimal getMontoPagado() { return montoPagado; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}
