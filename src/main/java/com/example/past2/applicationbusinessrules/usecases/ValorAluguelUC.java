package com.example.past2.applicationbusinessrules.usecases;

import com.example.past2.enterprisebusinessrules.service.AluguelService;
import com.example.past2.interfaceadapters.dto.ValorAluguelTotalDTO;
import org.springframework.stereotype.Component;

@Component
public class ValorAluguelUC {

    private final AluguelService aluguelService;

    public ValorAluguelUC(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    public ValorAluguelTotalDTO execute(int codigo) {
        return aluguelService.buscaValorDeAluguel(codigo);
    }
}