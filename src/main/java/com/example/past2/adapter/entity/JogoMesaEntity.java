package com.example.past2.adapter.entity;

import com.example.past2.domain.model.TipoMesa;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("MESA")
public class JogoMesaEntity extends JogoEntity {

    @Enumerated(EnumType.STRING)
    private TipoMesa tipo;

    private Integer numeroPecas;

    // Getters e Setters
}
