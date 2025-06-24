package com.example.past2.enterprisebusinessrules.entity;

import com.example.past2.enterprisebusinessrules.model.TipoEletronico;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@DiscriminatorValue("ELETRONICO")
@NoArgsConstructor
@AllArgsConstructor
public class JogoEletronicoEntity extends JogoEntity {
    @Enumerated(EnumType.STRING)
    private TipoEletronico tipo;
    private String plataforma;

    public JogoEletronicoEntity(String nome, Double valorBase, TipoEletronico tipo, String plataforma) {
        super(null, nome, valorBase);
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
