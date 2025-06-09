package com.example.past2.infrastructure.persistence.entity;

import com.example.past2.domain.model.TipoEletronico;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("ELETRONICO")
public class JogoEletronicoEntity extends JogoEntity {

    @Enumerated(EnumType.STRING)
    private TipoEletronico tipo;

    private String plataforma;

}
