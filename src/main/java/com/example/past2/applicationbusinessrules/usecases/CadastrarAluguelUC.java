package com.example.past2.applicationbusinessrules.usecases;

import com.example.past2.enterprisebusinessrules.service.AluguelService;
import com.example.past2.interfaceadapters.dto.AluguelDTO;
import org.springframework.stereotype.Component;

@Component
public class CadastrarAluguelUC {
    private final AluguelService aluguelService;

    public CadastrarAluguelUC(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    public boolean execute(AluguelDTO aluguelDTO) {
        return aluguelService.cadastrarAluguel(aluguelDTO);
    }
}
