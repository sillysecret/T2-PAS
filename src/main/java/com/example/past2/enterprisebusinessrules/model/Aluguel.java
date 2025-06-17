package com.example.past2.enterprisebusinessrules.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Aluguel {
    private Integer identificador;
    private LocalDate dataInicial;
    private Integer periodo;
    private Cliente cliente;
    private Jogo jogo;

    public Aluguel() {}

    public Aluguel(Integer identificador, LocalDate dataInicial, Integer periodo, Cliente cliente, Jogo jogo) {
        this.identificador = identificador;
        this.dataInicial = dataInicial;
        this.periodo = periodo;
        this.cliente = cliente;
        this.jogo = jogo;
    }

}