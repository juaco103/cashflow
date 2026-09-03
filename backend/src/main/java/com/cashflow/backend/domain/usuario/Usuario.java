package com.cashflow.backend.domain.usuario;

public class Usuario {

    private final Long id;
    private final String username;
    private final String passwordHash;
    
    public Usuario(Long id, String username, String passwordHash) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("El username es obligatorio");
        }
        if (passwordHash == null || passwordHash.isBlank()) {
            throw new IllegalArgumentException("El passwordHash es obligatorio");
        }

        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }
    
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }    
}
