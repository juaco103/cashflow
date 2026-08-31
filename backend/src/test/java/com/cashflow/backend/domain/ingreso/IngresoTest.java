package com.cashflow.backend.domain.ingreso;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IngresoTest {

    @Test
    void seCreaUnIngresoValidoCorrectamente() {
        Ingreso ingreso = new Ingreso(1L, "Salario Indra", BigDecimal.valueOf(5900000), null, null);

        assertThat(ingreso.getDescripcion()).isEqualTo("Salario Indra");
        assertThat(ingreso.getValor()).isEqualByComparingTo("5900000");
    }    

    @Test
    void noSePuedeCrearUnIngresoConDescripcionVacia() {
        assertThatThrownBy(() -> new Ingreso(1L, "  ", BigDecimal.valueOf(1000), null, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("descripcion");
    }

    @Test
    void noSePuedeCrearUnIngresoConValorCeroONegativo() {
        assertThatThrownBy(() -> new Ingreso(1L, "Salario", BigDecimal.ZERO, null, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("valor");
    }    
}
