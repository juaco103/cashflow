package com.cashflow.backend.application.gasto;

import com.cashflow.backend.domain.gasto.Gasto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GastoServiceTest {
    
    @Mock
    private GastoRepository gastoRepository;
    
    @Test
    void registrarGastoLoGuardaEnElRepositorioYDevuelveElResultado() {
        GastoService gastoService = new GastoService(gastoRepository);
        Gasto gastoAGuardar = new Gasto(null, "Internet", BigDecimal.valueOf(93000), null, null, null);
        Gasto gastoGuardado = new Gasto(1L, "Internet", BigDecimal.valueOf(93000), null, null, null);
        when(gastoRepository.guardar(gastoAGuardar)).thenReturn(gastoGuardado);

        Gasto resultado = gastoService.registrarGasto(gastoAGuardar);

        assertThat(resultado.getId()).isEqualTo(1L);
        verify(gastoRepository).guardar(gastoAGuardar);
    }

    @Test
    void listarGastosDevuelveLoQueRetornaElRepositorio() {
        GastoService gastoService = new GastoService(gastoRepository);
        Gasto gasto = new Gasto(1L, "Internet", BigDecimal.valueOf(93000), null, null, null);
        when(gastoRepository.listarTodos()).thenReturn(List.of(gasto));

        List<Gasto> resultado = gastoService.listarGastos();

        assertThat(resultado).containsExactly(gasto);
    }    
}
