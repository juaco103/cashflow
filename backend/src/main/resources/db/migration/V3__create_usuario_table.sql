CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(100) NOT NULL
);

INSERT INTO usuarios (username, password_hash) VALUES ('juaco103', '$2a$10$QiMntYDFU4ANol3V38zIQu/oIEBTvkz4wxDV/29Z.2LP5pDZYEwN.');