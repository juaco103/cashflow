package com.cashflow.backend.application.usuario;


import com.cashflow.backend.domain.usuario.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AutenticacionServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private CodificadorContrasena codificadorContrasena;

    @Mock
    private GeneradorToken generadorToken;

    @Test
    void loginExitosoDevuelveUnToken() {
        AutenticacionService autenticacionService =
                new AutenticacionService(usuarioRepository, codificadorContrasena, generadorToken);
        Usuario usuario = new Usuario(1L, "joaco", "hashGuardado");

        when(usuarioRepository.buscarPorUsername("joaco")).thenReturn(Optional.of(usuario));
        when(codificadorContrasena.coincide("contrasenaCorrecta", "hashGuardado")).thenReturn(true);
        when(generadorToken.generar("joaco")).thenReturn("token-generado");

        String resultado = autenticacionService.login("joaco", "contrasenaCorrecta");

        assertThat(resultado).isEqualTo("token-generado");
    }

    @Test
    void loginConUsuarioInexistenteLanzaCredencialesInvalidas() {
        AutenticacionService autenticacionService =
                new AutenticacionService(usuarioRepository, codificadorContrasena, generadorToken);

        when(usuarioRepository.buscarPorUsername("desconocido")).thenReturn(Optional.empty());

        assertThatThrownBy(() -> autenticacionService.login("desconocido", "cualquiera"))
                .isInstanceOf(CredencialesInvalidasException.class);
    }

    @Test
    void loginConContrasenaIncorrectaLanzaCredencialesInvalidas() {
        AutenticacionService autenticacionService =
                new AutenticacionService(usuarioRepository, codificadorContrasena, generadorToken);
        Usuario usuario = new Usuario(1L, "joaco", "hashGuardado");

        when(usuarioRepository.buscarPorUsername("joaco")).thenReturn(Optional.of(usuario));
        when(codificadorContrasena.coincide("contrasenaIncorrecta", "hashGuardado")).thenReturn(false);

        assertThatThrownBy(() -> autenticacionService.login("joaco", "contrasenaIncorrecta"))
                .isInstanceOf(CredencialesInvalidasException.class);
    }    
}