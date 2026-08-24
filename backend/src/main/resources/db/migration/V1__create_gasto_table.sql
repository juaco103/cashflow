CREATE TABLE gastos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    valor DECIMAL(12,2) NOT NULL,
    monto_pagado DECIMAL(12,2) NOT NULL DEFAULT 0,
    fecha_vencimiento DATE NULL,
    fecha_creacion DATETIME NOT NULL
);