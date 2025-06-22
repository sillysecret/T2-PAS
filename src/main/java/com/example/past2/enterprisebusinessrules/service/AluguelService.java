package com.example.past2.enterprisebusinessrules.service;

import com.example.past2.enterprisebusinessrules.model.Aluguel;
import com.example.past2.enterprisebusinessrules.repository.IAluguelRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelService {
    private final IAluguelRepository aluguelRepository;

    public AluguelService(IAluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public List<Aluguel> listarTodos() {
        return aluguelRepository.findAll();
    }
}
