package com.example.past2.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("EMPRESARIAL")
public class EmpresarialEntity extends ClienteEntity {

    private String nomeFantasia;
    private String cnpj;
}
