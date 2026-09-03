package com.cashflow.backend.infrastructure.usuario;

import com.cashflow.backend.domain.usuario.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mysql.MySQLContainer;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class UsuarioRepositoryAdapterIT {

    @Container
    @ServiceConnection
    static MySQLContainer mysql = new MySQLContainer("mysql:8.0");

    @Autowired
    private UsuarioRepositoryAdapter usuarioRepositoryAdapter;

    @Autowired
    private SpringDataUsuarioRepository springDataUsuarioRepository;

    @Test
    void buscaElUsuarioSembradoPorLaMigracionPorSuUsername() {
        String usernameSembrado = springDataUsuarioRepository.findAll().get(0).getUsername();

        Optional<Usuario> encontrado = usuarioRepositoryAdapter.buscarPorUsername(usernameSembrado);

        assertThat(encontrado).isPresent();
    }

    @Test
    void devuelveVacioSiElUsernameNoExiste() {
        Optional<Usuario> resultado = usuarioRepositoryAdapter.buscarPorUsername("no-existe-este-usuario");

        assertThat(resultado).isEmpty();
    }
}