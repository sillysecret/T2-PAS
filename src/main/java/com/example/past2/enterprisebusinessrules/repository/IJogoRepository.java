package com.example.past2.enterprisebusinessrules.repository;

import com.example.past2.enterprisebusinessrules.model.Jogo;

import java.util.List;

public interface IJogoRepository {
    List<Jogo> findAll();

    Jogo findById(Integer id);

    Jogo save(Jogo jogo);
}
