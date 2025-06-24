package com.example.past2.interfaceadapters.dto;

import lombok.Data;

@Data
public class ValorAluguelTotalDTO {
    private int jogoId;
    private int aluguelId;
    private int clienteId;
    private Double value;
}
