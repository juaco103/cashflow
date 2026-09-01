CREATE TABLE ingresos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    valor DECIMAL(12,2) NOT NULL,
    fecha DATE NULL,
    fecha_creacion DATETIME NOT NULL
);