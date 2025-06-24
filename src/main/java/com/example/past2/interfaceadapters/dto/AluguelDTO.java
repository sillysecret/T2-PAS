package com.example.past2.interfaceadapters.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AluguelDTO {
    private LocalDate dataInicial;
    private Integer periodo;
    private Integer numeroCliente;
    private Integer codigoJogo;
}
