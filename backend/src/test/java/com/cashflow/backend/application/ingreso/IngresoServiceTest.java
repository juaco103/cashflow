package com.cashflow.backend.application.ingreso;

import com.cashflow.backend.domain.ingreso.Ingreso;
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
class IngresoServiceTest {
    
    @Mock
    private IngresoRepository ingresoRepository;

    @Test
    void registrarIngresoLoGuardaEnElRepositorioYDevuelveElResultado() {
        IngresoService ingresoService = new IngresoService(ingresoRepository);
        Ingreso ingresoAGuardar = new Ingreso(null, "Salario", BigDecimal.valueOf(5900000), null, null);
        Ingreso ingresoGuardado = new Ingreso(1L, "Salario", BigDecimal.valueOf(5900000), null, null);
        when(ingresoRepository.guardar(ingresoAGuardar)).thenReturn(ingresoGuardado);

        Ingreso resultado = ingresoService.registrarIngreso(ingresoAGuardar);

        assertThat(resultado.getId()).isEqualTo(1L);
        verify(ingresoRepository).guardar(ingresoAGuardar);
    }
    
    @Test
    void listarIngresosDevuelveLoQueRetornaElRepositorio() {
        IngresoService ingresoService = new IngresoService(ingresoRepository);
        Ingreso ingreso = new Ingreso(1L, "Salario", BigDecimal.valueOf(5900000), null, null);
        when(ingresoRepository.listarTodos()).thenReturn(List.of(ingreso));

        List<Ingreso> resultado = ingresoService.listarIngresos();

        assertThat(resultado).containsExactly(ingreso);
    }    
}
