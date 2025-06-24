package com.example.past2.enterprisebusinessrules.repository;

import com.example.past2.enterprisebusinessrules.model.Jogo;
import com.example.past2.interfaceadapters.entity.JogoEntity;

import java.util.List;
import java.util.Optional;

public interface IJogoRepository {
    List<Jogo> findAll();

    Jogo findById(Integer id);

    Jogo save(Jogo jogo);

    Optional<JogoEntity> findEntityById(Integer codigoJogo);
}
