package com.example.past2.enterprisebusinessrules.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@DiscriminatorValue("INDIVIDUAL")
@NoArgsConstructor
@AllArgsConstructor
public class IndividualEntity extends ClienteEntity {

    public IndividualEntity(String nome, String endereco, String cpf) {
        super(null, nome, endereco);
        this.cpf = cpf;
    }

    private String cpf;
}
