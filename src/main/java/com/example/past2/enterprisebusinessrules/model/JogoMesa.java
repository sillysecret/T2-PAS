package com.example.past2.enterprisebusinessrules.model;

import lombok.Data;

@Data
public class JogoMesa extends Jogo {
    private TipoMesa tipo;
    private Integer numeroPecas;

    public JogoMesa() {
    }

    public JogoMesa(Integer codigo, String nome, Double valorBase, TipoMesa tipo, Integer numeroPecas) {
        super(codigo, nome, valorBase);
        this.tipo = tipo;
        this.numeroPecas = numeroPecas;
    }

    @Override
    public Double getValorAluguel() {
        return switch (tipo) {
            case TABULEIRO -> getValorBase() * numeroPecas;
            case CARTAS -> getValorBase() * (1.2);
        };
    }
}
