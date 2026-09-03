package com.cashflow.backend.domain.usuario;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UsuarioTest {

    @Test
    void seCreaUnUsuarioValidoCorrectamente() {
        Usuario usuario = new Usuario(1L, "joaco", "hash123");

        assertThat(usuario.getUsername()).isEqualTo("joaco");
        assertThat(usuario.getPasswordHash()).isEqualTo("hash123");
    }

    @Test
    void noSePuedeCrearUnUsuarioConUsernameVacio() {
        assertThatThrownBy(() -> new Usuario(1L, "  ", "hash123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("username");
    }

    @Test
    void noSePuedeCrearUnUsuarioConPasswordHashVacio() {
        assertThatThrownBy(() -> new Usuario(1L, "joaco", "  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("passwordHash");
    }
}