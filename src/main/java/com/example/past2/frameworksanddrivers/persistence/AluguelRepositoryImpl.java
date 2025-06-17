package com.example.past2.frameworksanddrivers.persistence;

import com.example.past2.enterprisebusinessrules.model.Aluguel;
import com.example.past2.enterprisebusinessrules.repository.IAluguelRepository;
import com.example.past2.interfaceadapters.mapper.AluguelMapper;
import com.example.past2.interfaceadapters.mapper.JogoMapper;
import com.example.past2.enterprisebusinessrules.model.Jogo;
import com.example.past2.enterprisebusinessrules.repository.IJogoRepository;

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

}
