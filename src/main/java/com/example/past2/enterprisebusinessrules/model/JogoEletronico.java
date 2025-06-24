package com.example.past2.enterprisebusinessrules.model;

import lombok.Data;

@Data
public class JogoEletronico extends Jogo {
    private TipoEletronico tipo;
    private String plataforma;

    public JogoEletronico() {
    }

    public JogoEletronico(Integer codigo, String nome, Double valorBase, TipoEletronico tipo, String plataforma) {
        super(codigo, nome, valorBase);
        this.tipo = tipo;
        this.plataforma = plataforma;
    }

    @Override
    public Double getValorAluguel() {
        Double acrescimo = switch (tipo) {
            case AVENTURA -> 0.05;
            case ESTRATEGIA -> 0.15;
            case SIMULACAO -> 0.25;
        };
        return getValorBase() + (getValorBase() * acrescimo);
    }
}
