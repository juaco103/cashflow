package com.cashflow.backend.infrastructure.ingreso;

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
@Table(name = "ingresos")
public class IngresoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal valor;

    @Column
    private LocalDate fecha;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;
    
    protected IngresoJpaEntity() {
    }

    public IngresoJpaEntity(Long id, String descripcion, BigDecimal valor, LocalDate fecha, LocalDateTime fechaCreacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
        this.fecha = fecha;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public BigDecimal getValor() { return valor; }
    public LocalDate getFecha() { return fecha; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }    
}

