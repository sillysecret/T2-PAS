package com.example.past2.application.service;

import com.example.past2.domain.model.Jogo;
import com.example.past2.domain.repository.IJogoRepository;
import com.example.past2.infrastructure.mapper.JogoMapper;
import com.example.past2.infrastructure.persistence.JogoJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogoService {
    private final IJogoRepository jogoRepository;

    public JogoService(IJogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> listarTodos() {
        return jogoRepository.findAll();
    }
}

