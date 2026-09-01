package com.cashflow.backend.infrastructure.ingreso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataIngresoRepository extends JpaRepository<IngresoJpaEntity, Long> {   
}
