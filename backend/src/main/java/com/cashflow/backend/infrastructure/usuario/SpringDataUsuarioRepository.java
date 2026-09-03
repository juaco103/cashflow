package com.cashflow.backend.infrastructure.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUsuarioRepository extends JpaRepository<UsuarioJpaEntity, Long> {
    Optional<UsuarioJpaEntity> findByUsername(String username);
}