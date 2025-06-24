package com.example.past2.interfaceadapters.entity;

import com.example.past2.enterprisebusinessrules.model.TipoEletronico;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;

import static com.example.past2.enterprisebusinessrules.model.TipoEletronico.*;

@Data
@Entity
@DiscriminatorValue("ELETRONICO")
public class JogoEletronicoEntity extends JogoEntity {

    @Enumerated(EnumType.STRING)
    private TipoEletronico tipo;

    private String plataforma;

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
