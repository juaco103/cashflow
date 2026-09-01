package com.cashflow.backend.domain.gasto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GastoTest {

    @Test
    void unGastoNuevoSinMontoPagadoQuedaPendiente() {
        Gasto gasto = new Gasto(1L, "Internet", BigDecimal.valueOf(93000), null, null, null);

        assertThat(gasto.getPendiente()).isEqualByComparingTo("93000");
        assertThat(gasto.getEstado()).isEqualTo(EstadoGasto.PENDIENTE);
    }

    @Test
    void unGastoConPagoParcialQuedaParcialmentePagado() {
        Gasto gasto = new Gasto(1L, "Internet", BigDecimal.valueOf(93000), BigDecimal.valueOf(40000), null, null);

        assertThat(gasto.getPendiente()).isEqualByComparingTo("53000");
        assertThat(gasto.getEstado()).isEqualTo(EstadoGasto.PARCIALMENTE_PAGADO);
    }
    
    @Test
    void unGastoPagadoCompletoQuedaPagado() {
        Gasto gasto = new Gasto(1L, "Internet", BigDecimal.valueOf(93000), BigDecimal.valueOf(93000), null, null);

        assertThat(gasto.getPendiente()).isEqualByComparingTo("0");
        assertThat(gasto.getEstado()).isEqualTo(EstadoGasto.PAGADO);
    }    

    @Test
    void noSePuedeCrearUnGastoConDescripcionVacia() {
        assertThatThrownBy(() -> new Gasto(1L, "  ", BigDecimal.valueOf(1000), null, null, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("descripcion");
    }
    
    @Test
    void noSePuedeCrearUnGastoConValorCeroONegativo() {
        assertThatThrownBy(() -> new Gasto(1L, "Internet", BigDecimal.ZERO, null, null, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("valor");
    }
    
    @Test
    void noSePuedeCrearUnGastoConMontoPagadoMayorAlValor() {
        assertThatThrownBy(() -> new Gasto(1L, "Internet", BigDecimal.valueOf(1000), BigDecimal.valueOf(2000), null, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("no puede superar");
    }    
}
