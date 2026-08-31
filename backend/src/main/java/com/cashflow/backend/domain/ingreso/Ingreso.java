package com.cashflow.backend.domain.ingreso;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ingreso {

    private final Long id;
    private final String descripcion;
    private final BigDecimal valor;
    private final LocalDate fecha;
    private final LocalDateTime fechaCreacion;    

    public Ingreso(Long id, String descripcion, BigDecimal valor, LocalDate fecha, LocalDateTime fechaCreacion) {
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("La descripcion es obligatoria");
        }
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El valor debe ser mayor que cero");
        }

        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
        this.fecha = fecha;
        this.fechaCreacion = fechaCreacion == null ? LocalDateTime.now() : fechaCreacion;
    }

    public Long getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public BigDecimal getValor() { return valor; }
    public LocalDate getFecha() { return fecha; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }    
}
