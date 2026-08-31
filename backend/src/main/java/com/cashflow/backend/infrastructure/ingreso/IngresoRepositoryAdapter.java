package com.cashflow.backend.infrastructure.ingreso;

import com.cashflow.backend.application.ingreso.IngresoRepository;
import com.cashflow.backend.domain.ingreso.Ingreso;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IngresoRepositoryAdapter implements IngresoRepository {

    private final SpringDataIngresoRepository springDataIngresoRepository;    

    public IngresoRepositoryAdapter(SpringDataIngresoRepository springDataIngresoRepository) {
        this.springDataIngresoRepository = springDataIngresoRepository;
    }

    @Override
    public Ingreso guardar(Ingreso ingreso) {
        IngresoJpaEntity entidad = toEntity(ingreso);
        IngresoJpaEntity guardada = springDataIngresoRepository.save(entidad);
        return toDomain(guardada);
    }

    @Override
    public List<Ingreso> listarTodos() {
        return springDataIngresoRepository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }
    
    private IngresoJpaEntity toEntity(Ingreso ingreso) {
        return new IngresoJpaEntity(
                ingreso.getId(),
                ingreso.getDescripcion(),
                ingreso.getValor(),
                ingreso.getFecha(),
                ingreso.getFechaCreacion()
        );
    }

    private Ingreso toDomain(IngresoJpaEntity entidad) {
        return new Ingreso(
                entidad.getId(),
                entidad.getDescripcion(),
                entidad.getValor(),
                entidad.getFecha(),
                entidad.getFechaCreacion()
        );
    }    
}
