# CashFlow — Documento de Arquitectura

Este documento es el "mapa" vivo del proyecto. Cada decisión importante de diseño se registra aca antes de implementarse, y se actualiza a medida que el proyecto evoluciona.

## Stack tecnologico

| Componente          | Tecnologia                     |
|---------------------|---------------------------------|
| Backend             | Java 21                        |
| Framework           | Spring Boot 3.x                |
| API                 | REST                           |
| Seguridad           | Spring Security + JWT (desde v0.2) |
| Persistencia        | Spring Data JPA                |
| Base de datos       | MySQL (Hostinger)              |
| Migraciones         | Flyway                         |
| Frontend            | React                          |
| Build frontend      | Vite                           |
| UI                  | Material UI                    |
| Cliente HTTP        | Axios                          |
| Tests backend       | JUnit + Mockito                |
| Tests de integracion| Testcontainers                 |
| Documentacion API   | OpenAPI / Swagger              |
| Control de versiones| Git + GitHub                   |

## Arquitectura del backend

Arquitectura Hexagonal (Ports & Adapters) simplificada:

    backend/
    +-- domain/          # Entidades y reglas de negocio puras, sin dependencias externas
    +-- application/      # Casos de uso: orquestan el dominio
    +-- infrastructure/   # Adaptadores: JPA, MySQL, servicios externos
    +-- api/               # Adaptadores de entrada: Controllers REST

## Estrategia de Git (Git Flow)

- **`main`**: solo versiones estables y publicadas. Nunca se commitea directo aca.
- **`develop`**: rama de integracion. Todas las features terminadas llegan aca primero.
- **`feature/<nombre>`**: una por cada funcionalidad. Se crea desde `develop`, se mergea de vuelta a `develop` al terminar.
- **`release/<version>`**: se crea desde `develop` cuando el conjunto de features de una version esta completo. Aca solo se hacen ajustes finales (bugfixes, no features nuevas). Al cerrarse, se mergea a `main` **y** de vuelta a `develop`.
- **`hotfix/<nombre>`** (si hace falta): se crea desde `main` para arreglos urgentes en produccion. Se mergea a `main` y a `develop`.

Regla clave: `main` y `develop` **nunca se mergean directamente entre si** — todo pasa por una rama `release`.

## Modelo de datos

_(Se documenta a medida que se define cada entidad. Ver seccion de Gasto mas abajo cuando se implemente HU-001.)_

## Roadmap de versiones

- v0.1 — Registro de gastos e ingresos, dashboard (sin login)
- v0.2 — Autenticacion
- v0.3 — Multiusuario
- v0.4 — Gastos recurrentes
- v0.5 — Calendario
- v0.6 — IA
