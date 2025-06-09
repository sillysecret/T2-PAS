package com.example.past2.domain.model;

import lombok.Data;

@Data
public abstract class Cliente {
    private Integer numero;
    private String nome;
    private String endereco;

    public Cliente() {}

    public Cliente(Integer numero, String nome, String endereco) {
        this.numero = numero;
        this.nome = nome;
        this.endereco = endereco;
    }
}

