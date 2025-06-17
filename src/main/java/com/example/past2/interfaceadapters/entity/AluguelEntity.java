package com.example.past2.interfaceadapters.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AluguelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;

    private java.time.LocalDate dataInicial;
    private Integer periodo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private JogoEntity jogo;

}
