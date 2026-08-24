package com.cashflow.backend.infrastructure.gasto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataGastoRepository extends JpaRepository<GastoJpaEntity, Long> {
}
