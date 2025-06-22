package com.example.past2.enterprisebusinessrules.model;

import lombok.Data;

@Data
public class Empresarial extends Cliente {
    private String nomeFantasia;
    private String cnpj;

    public Empresarial() {
    }

    public Empresarial(Integer numero, String nome, String endereco, String nomeFantasia, String cnpj) {
        super(numero, nome, endereco);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

}
