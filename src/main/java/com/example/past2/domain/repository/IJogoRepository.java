package com.example.past2.domain.repository;

import com.example.past2.domain.model.Jogo;

import java.util.List;

public interface IJogoRepository {
    List<Jogo> findAll();
    Jogo findById(Integer id);
}
