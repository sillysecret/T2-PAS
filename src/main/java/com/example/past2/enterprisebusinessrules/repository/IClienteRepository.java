package com.example.past2.enterprisebusinessrules.repository;

import com.example.past2.enterprisebusinessrules.model.Cliente;
import com.example.past2.interfaceadapters.entity.ClienteEntity;

import java.util.List;
import java.util.Optional;

public interface IClienteRepository {
    Cliente findById(int clientId);
    Optional<ClienteEntity> findEntityById(int clientId);

    List<Cliente> findAll();

    void save(ClienteEntity clienteEntity);
}
