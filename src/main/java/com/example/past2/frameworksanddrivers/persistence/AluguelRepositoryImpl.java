package com.example.past2.frameworksanddrivers.persistence;

import com.example.past2.enterprisebusinessrules.model.Aluguel;
import com.example.past2.enterprisebusinessrules.repository.IAluguelRepository;
import com.example.past2.enterprisebusinessrules.entity.AluguelEntity;
import com.example.past2.interfaceadapters.mapper.AluguelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AluguelRepositoryImpl implements IAluguelRepository {
    private final IAluguelJpaRepository jpaRepository;

    public AluguelRepositoryImpl(IAluguelJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<Aluguel> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(AluguelMapper::toModel)
                .toList();
    }

    public Aluguel findById(int codigo) {
        return jpaRepository.findById(codigo)
                .map(AluguelMapper::toModel)
                .orElse(null);
    }

    @Override
    public void save(AluguelEntity aluguel) {
        jpaRepository.save(aluguel);
        return;
    }

    @Override
    public List<Aluguel> findByClienteId(int clienteId) {
        return jpaRepository.findByClienteNumero(clienteId)
                .stream()
                .map(AluguelMapper::toModel)
                .toList();
    }

    @Override
    public List<Aluguel> findByJogoId(int jogoId) {
        return jpaRepository.findByJogoCodigo(jogoId)
                .stream()
                .map(AluguelMapper::toModel)
                .toList();
    }
}
