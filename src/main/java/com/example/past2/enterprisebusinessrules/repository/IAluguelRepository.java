package com.example.past2.enterprisebusinessrules.repository;

import com.example.past2.enterprisebusinessrules.model.Aluguel;
import com.example.past2.interfaceadapters.entity.AluguelEntity;

import java.util.List;

public interface IAluguelRepository {
    List<Aluguel> findAll();

    Aluguel findById(int codigo);

    void save(AluguelEntity aluguel);

    List<Aluguel> findByClienteId(int clienteId);

    List<Aluguel> findByJogoId(int jogoId);
}
