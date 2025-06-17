package com.example.past2.enterprisebusinessrules.model;

import lombok.Data;

@Data
public class Individual extends Cliente {
    private String cpf;

    public Individual() {}

    public Individual(Integer numero, String nome, String endereco, String cpf) {
        super(numero, nome, endereco);
        this.cpf = cpf;
    }

}
