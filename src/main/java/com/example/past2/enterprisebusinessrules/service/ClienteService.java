package com.example.past2.enterprisebusinessrules.service;

import com.example.past2.enterprisebusinessrules.model.Cliente;
import com.example.past2.enterprisebusinessrules.repository.IClienteRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
}
