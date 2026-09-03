package com.cashflow.backend.application.usuario;

public interface CodificadorContrasena {
    boolean coincide(String contrasenaPlana, String contrasenaHasheada);
}
