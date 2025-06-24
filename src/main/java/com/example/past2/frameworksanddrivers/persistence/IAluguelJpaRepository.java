package com.example.past2.frameworksanddrivers.persistence;

import com.example.past2.interfaceadapters.entity.AluguelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAluguelJpaRepository extends JpaRepository<AluguelEntity, Integer> {
    List<AluguelEntity> findByClienteNumero(Integer numero);
    List<AluguelEntity> findByJogoCodigo(Integer codigo);
}
