package com.cashflow.backend.infrastructure.ingreso;

import com.cashflow.backend.domain.ingreso.Ingreso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mysql.MySQLContainer;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class IngresoRepositoryAdapterIT {
    @Container
    @ServiceConnection
    static MySQLContainer mysql = new MySQLContainer("mysql:8.0");

    @Autowired
    private IngresoRepositoryAdapter ingresoRepositoryAdapter;
    
    @Test
    void guardaYRecuperaUnIngresoDesdeMySqlReal() {
        Ingreso ingreso = new Ingreso(null, "Salario Indra", BigDecimal.valueOf(5900000),
                LocalDate.of(2026, 9, 1), null);

        Ingreso guardado = ingresoRepositoryAdapter.guardar(ingreso);

        assertThat(guardado.getId()).isNotNull();
        assertThat(ingresoRepositoryAdapter.listarTodos())
                .extracting(Ingreso::getDescripcion)
                .contains("Salario Indra");
    }    
}
