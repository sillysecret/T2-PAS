package com.example.past2.infrastructure.persistence;

import com.example.past2.domain.model.Jogo;
import com.example.past2.domain.repository.IJogoRepository;
import com.example.past2.infrastructure.mapper.JogoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JogoRepositoryImpl implements IJogoRepository {
    private final JogoJpaRepository jpaRepository;

    public JogoRepositoryImpl(JogoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<Jogo> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(JogoMapper::toModel)
                .toList();
    }
}
