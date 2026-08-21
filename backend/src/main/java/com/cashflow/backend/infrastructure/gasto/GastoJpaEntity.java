package com.cashflow.backend.infrastructure.gasto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "gastos")
public class GastoJpaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal valor;

    @Column(name = "monto_pagado", nullable = false, precision = 12, scale = 2)
    private BigDecimal montoPagado;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    protected GastoJpaEntity() {
        // JPA exige un constructor sin argumentos
    }    

    public GastoJpaEntity(Long id, String descripcion, BigDecimal valor, BigDecimal montoPagado,
                           LocalDate fechaVencimiento, LocalDateTime fechaCreacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
        this.montoPagado = montoPagado;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaCreacion = fechaCreacion;
    }
    
    public Long getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public BigDecimal getValor() { return valor; }
    public BigDecimal getMontoPagado() { return montoPagado; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}
