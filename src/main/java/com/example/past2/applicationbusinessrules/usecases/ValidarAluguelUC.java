package com.example.past2.applicationbusinessrules.usecases;

import com.example.past2.enterprisebusinessrules.service.AluguelService;
import org.springframework.stereotype.Component;

@Component
public class ValidarAluguelUC {

    private final AluguelService aluguelService;

    public ValidarAluguelUC(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    public boolean execute(int codigo) {
        return aluguelService.validar(codigo);
    }
}
