package com.example.past2.enterprisebusinessrules.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_jogo")
@NoArgsConstructor
@AllArgsConstructor
public abstract class JogoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String nome;
    private Double valorBase;

    public abstract Double getValorAluguel();
}
