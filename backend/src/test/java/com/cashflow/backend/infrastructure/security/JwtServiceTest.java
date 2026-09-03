package com.cashflow.backend.infrastructure.security;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JwtServiceTest {

    private final JwtService jwtService =
            new JwtService("clave-secreta-de-prueba-para-tests-12345678", 3600000);

    @Test
    void generaUnTokenYPuedeExtraerElUsername() {
        String token = jwtService.generarToken("joaco");

        assertThat(jwtService.extraerUsername(token)).isEqualTo("joaco");
    }

    @Test
    void unTokenRecienGeneradoEsValido() {
        String token = jwtService.generarToken("joaco");

        assertThat(jwtService.esValido(token)).isTrue();
    }

    @Test
    void unTokenConFormatoInvalidoNoEsValido() {
        assertThat(jwtService.esValido("esto-no-es-un-token-valido")).isFalse();
    }
}