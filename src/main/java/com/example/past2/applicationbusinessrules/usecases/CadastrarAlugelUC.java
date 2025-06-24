package com.example.past2.applicationbusinessrules.usecases;

import com.example.past2.enterprisebusinessrules.service.AluguelService;
import com.example.past2.enterprisebusinessrules.service.ClienteService;
import com.example.past2.interfaceadapters.dto.AluguelDTO;
import com.example.past2.interfaceadapters.dto.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class CadastrarAlugelUC {
    private final AluguelService aluguelService;

    public CadastrarAlugelUC(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    public boolean execute(AluguelDTO aluguelDTO) {
        return aluguelService.cadastrarAluguel(aluguelDTO);
    }
}
