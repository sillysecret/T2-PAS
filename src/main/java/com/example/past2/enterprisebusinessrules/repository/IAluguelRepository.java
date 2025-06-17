package com.example.past2.enterprisebusinessrules.repository;

import com.example.past2.enterprisebusinessrules.model.Aluguel;

import java.util.List;

public interface IAluguelRepository {
    List<Aluguel> findAll();
}
