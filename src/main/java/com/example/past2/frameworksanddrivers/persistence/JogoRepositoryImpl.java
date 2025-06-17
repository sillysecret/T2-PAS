package com.example.past2.frameworksanddrivers.persistence;

import com.example.past2.interfaceadapters.mapper.JogoMapper;
import com.example.past2.enterprisebusinessrules.model.Jogo;
import com.example.past2.enterprisebusinessrules.repository.IJogoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JogoRepositoryImpl implements IJogoRepository {
    private final IJogoJpaRepository jpaRepository;

    public JogoRepositoryImpl(IJogoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<Jogo> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(JogoMapper::toModel)
                .toList();
    }

    public Jogo findById(Integer id) {
        return jpaRepository.findById(id)
                .map(JogoMapper::toModel)
                .orElse(null);
    }
}
