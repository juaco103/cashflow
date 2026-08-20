# CashFlow

Aplicacion personal de finanzas para reemplazar una hoja de Google Sheets de control de gastos e ingresos, construida como proyecto de practica de arquitectura y buenas practicas de desarrollo de software.

## Stack

- **Backend**: Java 21, Spring Boot 3.x, Spring Data JPA, Spring Security (JWT), MySQL, Flyway
- **Frontend**: React + Vite, Material UI, Axios
- **Arquitectura**: Hexagonal (Ports & Adapters) simplificada

## Estructura del repositorio

    cashflow/
    |-- backend/     # API Spring Boot
    |-- frontend/    # SPA React
    +-- docs/        # Documentacion de arquitectura, base de datos y API

## Estado actual

En construccion - v0.1 en progreso.

## Roadmap

- [ ] v0.1 - Registro de gastos e ingresos, dashboard (sin login)
- [ ] v0.2 - Autenticacion
- [ ] v0.3 - Multiusuario
- [ ] v0.4 - Gastos recurrentes
- [ ] v0.5 - Calendario
- [ ] v0.6 - IA
