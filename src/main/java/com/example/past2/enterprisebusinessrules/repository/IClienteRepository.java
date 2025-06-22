package com.example.past2.enterprisebusinessrules.repository;

import com.example.past2.enterprisebusinessrules.model.Cliente;

import java.util.List;

public interface IClienteRepository {
    List<Cliente> findAll();
}
