package com.example.past2.frameworksanddrivers.persistence;

import com.example.past2.enterprisebusinessrules.model.Cliente;
import com.example.past2.enterprisebusinessrules.repository.IClienteRepository;
import com.example.past2.interfaceadapters.entity.ClienteEntity;
import com.example.past2.interfaceadapters.mapper.ClienteMapper;
import com.example.past2.interfaceadapters.mapper.JogoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositoryImpl implements IClienteRepository {
    private final IClienteJpaRepository jpaRepository;

    public ClienteRepositoryImpl(IClienteJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Cliente findById(int clientId) {
        return jpaRepository.findById(clientId)
                .map(ClienteMapper::toModel)
                .orElse(null);
    }

    @Override
    public Optional<ClienteEntity> findEntityById(int clientId) {
        return jpaRepository.findById(clientId);
    }

    @Override
    public List<Cliente> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(ClienteMapper::toModel)
                .toList();
    }

    @Override
    public void save(ClienteEntity clienteEntity) {
        jpaRepository.save(clienteEntity);
    }
}
