package com.example.past2.enterprisebusinessrules.entity;

import com.example.past2.enterprisebusinessrules.model.TipoMesa;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@DiscriminatorValue("MESA")
@NoArgsConstructor
public class JogoMesaEntity extends JogoEntity {
    @Enumerated(EnumType.STRING)
    private TipoMesa tipo;
    private Integer numeroPecas;

    public JogoMesaEntity(String nome, Double valorBase, TipoMesa tipo, Integer numeroPecas) {
        super(null, nome, valorBase);
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
