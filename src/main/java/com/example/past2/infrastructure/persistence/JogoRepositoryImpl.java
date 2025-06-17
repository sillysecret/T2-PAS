package com.example.past2.infrastructure.persistence;

import com.example.past2.adapter.mapper.JogoMapper;
import com.example.past2.domain.model.Jogo;
import com.example.past2.domain.repository.IJogoRepository;

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
