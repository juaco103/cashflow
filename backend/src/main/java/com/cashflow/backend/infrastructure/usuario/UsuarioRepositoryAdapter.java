package com.cashflow.backend.infrastructure.usuario;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cashflow.backend.application.usuario.UsuarioRepository;
import com.cashflow.backend.domain.usuario.Usuario;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepository {

    private final SpringDataUsuarioRepository springDataUsuarioRepository;

    public UsuarioRepositoryAdapter(SpringDataUsuarioRepository springDataUsuarioRepository) {
        this.springDataUsuarioRepository = springDataUsuarioRepository;
    }
    
    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return springDataUsuarioRepository.findByUsername(username)
                .map(this::toDomain);
    } 
    
    private Usuario toDomain(UsuarioJpaEntity entidad) {
        return new Usuario(entidad.getId(), entidad.getUsername(), entidad.getPasswordHash());
    }    
}
