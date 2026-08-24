package com.cashflow.backend.infrastructure.gasto;

import com.cashflow.backend.application.gasto.GastoRepository;
import com.cashflow.backend.domain.gasto.Gasto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GastoRepositoryAdapter implements GastoRepository{

    private final SpringDataGastoRepository springDataGastoRepository;

    public GastoRepositoryAdapter(SpringDataGastoRepository springDataGastoRepository) {
        this.springDataGastoRepository = springDataGastoRepository;
    }

    @Override
    public Gasto guardar(Gasto gasto) {
        GastoJpaEntity entidad = toEntity(gasto);
        GastoJpaEntity guardada = springDataGastoRepository.save(entidad);
        return toDomain(guardada);
    }

    @Override
    public List<Gasto> listarTodos() {
        return springDataGastoRepository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }
    
    private GastoJpaEntity toEntity(Gasto gasto) {
        return new GastoJpaEntity(
                gasto.getId(),
                gasto.getDescripcion(),
                gasto.getValor(),
                gasto.getMontoPagado(),
                gasto.getFechaVencimiento(),
                gasto.getFechaCreacion()
        );
    }  
    
    private Gasto toDomain(GastoJpaEntity entidad) {
        return new Gasto(
                entidad.getId(),
                entidad.getDescripcion(),
                entidad.getValor(),
                entidad.getMontoPagado(),
                entidad.getFechaVencimiento(),
                entidad.getFechaCreacion()
        );
    }    
}
