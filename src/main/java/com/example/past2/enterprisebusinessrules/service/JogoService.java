package com.example.past2.enterprisebusinessrules.service;

import com.example.past2.enterprisebusinessrules.model.Jogo;
import com.example.past2.enterprisebusinessrules.repository.IJogoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {
    private final IJogoRepository jogoRepository;

    public JogoService(IJogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> listarTodos() {
        return jogoRepository.findAll();
    }

    public boolean validar(Integer codigo) {
        Jogo jogo = jogoRepository.findById(codigo);

        return jogo != null;
    }

    public boolean cadastrar(Jogo jogo) {
        Jogo result = jogoRepository.save(jogo);

        return result != null;
    }
}
