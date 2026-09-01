package com.cashflow.backend.infrastructure.gasto;

import com.cashflow.backend.domain.gasto.Gasto;
import com.cashflow.backend.infrastructure.gasto.GastoRepositoryAdapter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.mysql.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
public class GastoRepositoryAdapterIT {
    
    @Container
    @ServiceConnection
    static MySQLContainer mysql = new MySQLContainer("mysql:8.0");

    @Autowired
    private GastoRepositoryAdapter gastoRepositoryAdapter;

    @Test
    void guardaYRecuperaUnGastoDesdeMySqlReal() {
        Gasto gasto = new Gasto(null, "Internet zipa", BigDecimal.valueOf(93000),
                null, LocalDate.of(2026, 9, 6), null);

        Gasto guardado = gastoRepositoryAdapter.guardar(gasto);

        assertThat(guardado.getId()).isNotNull();
        assertThat(gastoRepositoryAdapter.listarTodos())
                .extracting(Gasto::getDescripcion)
                .contains("Internet zipa");
    }    

}
