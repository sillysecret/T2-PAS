package com.example.past2.enterprisebusinessrules.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@DiscriminatorValue("EMPRESARIAL")
@NoArgsConstructor
public class EmpresarialEntity extends ClienteEntity {

    public EmpresarialEntity(String nome, String endereco, String nomeFantasia, String cnpj) {
        super(null, nome, endereco);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    private String nomeFantasia;
    private String cnpj;
}
