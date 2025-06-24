package com.example.past2.enterprisebusinessrules.model;

import lombok.Data;

@Data
public abstract class Jogo {
    private Integer codigo;
    private String nome;
    private Double valorBase;

    public Jogo() {
    }

    public Jogo(Integer codigo, String nome, Double valorBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorBase = valorBase;
    }

    public abstract Double getValorAluguel();

}
