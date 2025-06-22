package com.example.past2.frameworksanddrivers.persistence;

import com.example.past2.enterprisebusinessrules.model.Cliente;
import com.example.past2.enterprisebusinessrules.repository.IClienteRepository;
import com.example.past2.interfaceadapters.mapper.ClienteMapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepositoryImpl implements IClienteRepository {
    private final IClienteJpaRepository jpaRepository;

    public ClienteRepositoryImpl(IClienteJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<Cliente> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(ClienteMapper::toModel)
                .toList();
    }
}
