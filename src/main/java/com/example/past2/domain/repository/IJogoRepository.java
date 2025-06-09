package com.example.past2.domain.repository;

import com.example.past2.domain.model.Jogo;
import com.example.past2.infrastructure.persistence.entity.JogoEntity;

import java.util.List;

public interface IJogoRepository {
    List<Jogo> findAll();
}
