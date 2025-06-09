package com.example.past2.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("INDIVIDUAL")
public class IndividualEntity extends ClienteEntity {

    private String cpf;
}
