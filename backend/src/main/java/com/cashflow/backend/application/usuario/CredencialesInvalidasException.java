package com.cashflow.backend.application.usuario;

public class CredencialesInvalidasException extends RuntimeException {
    public CredencialesInvalidasException() {
        super("Usuario o contrasena incorrectos");
    }
}
