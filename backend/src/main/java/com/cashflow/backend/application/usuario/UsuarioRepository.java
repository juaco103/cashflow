package com.cashflow.backend.application.usuario;

import java.util.Optional;

import com.cashflow.backend.domain.usuario.Usuario;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorUsername(String username);
}