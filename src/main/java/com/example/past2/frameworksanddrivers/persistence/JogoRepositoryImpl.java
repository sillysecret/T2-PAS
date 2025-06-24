package com.example.past2.frameworksanddrivers.persistence;

import com.example.past2.enterprisebusinessrules.model.Jogo;
import com.example.past2.enterprisebusinessrules.repository.IJogoRepository;
import com.example.past2.interfaceadapters.entity.JogoEntity;
import com.example.past2.interfaceadapters.mapper.JogoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JogoRepositoryImpl implements IJogoRepository {
    private final IJogoJpaRepository jpaRepository;

    public JogoRepositoryImpl(IJogoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<Jogo> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(JogoMapper::entityToModel)
                .toList();
    }

    public Jogo findById(Integer id) {
        return jpaRepository.findById(id)
                .map(JogoMapper::entityToModel)
                .orElse(null);
    }

    public Jogo save(Jogo jogo) {
        JogoEntity jogoEntity = JogoMapper.toEntity(jogo);
        JogoEntity savedEntity = jpaRepository.save(jogoEntity);

        return JogoMapper.entityToModel(savedEntity);
    }

    @Override
    public Optional<JogoEntity> findEntityById(Integer codigoJogo) {
        return jpaRepository.findById(codigoJogo);
    }
}