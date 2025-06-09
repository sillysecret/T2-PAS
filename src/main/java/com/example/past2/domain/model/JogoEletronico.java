package com.example.past2.domain.model;

import lombok.Data;

@Data
public class JogoEletronico extends Jogo {
    private TipoEletronico tipo;
    private String plataforma;

    public JogoEletronico() {}

    public JogoEletronico(Integer codigo, String nome, Double valorBase, TipoEletronico tipo, String plataforma) {
        super(codigo, nome, valorBase);
        this.tipo = tipo;
        this.plataforma = plataforma;
    }

}
