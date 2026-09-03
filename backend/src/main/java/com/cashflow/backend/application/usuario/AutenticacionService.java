package com.cashflow.backend.application.usuario;

import com.cashflow.backend.domain.usuario.Usuario;

public class AutenticacionService {

    private final UsuarioRepository usuarioRepository;
    private final CodificadorContrasena codificadorContrasena;
    private final GeneradorToken generadorToken;

    public AutenticacionService(UsuarioRepository usuarioRepository,
                                 CodificadorContrasena codificadorContrasena,
                                 GeneradorToken generadorToken) {
        this.usuarioRepository = usuarioRepository;
        this.codificadorContrasena = codificadorContrasena;
        this.generadorToken = generadorToken;
    }
    
    public String login(String username, String contrasena) {
        Usuario usuario = usuarioRepository.buscarPorUsername(username)
                .orElseThrow(CredencialesInvalidasException::new);

        if (!codificadorContrasena.coincide(contrasena, usuario.getPasswordHash())) {
            throw new CredencialesInvalidasException();
        }

        return generadorToken.generar(usuario.getUsername());
    }    
}
