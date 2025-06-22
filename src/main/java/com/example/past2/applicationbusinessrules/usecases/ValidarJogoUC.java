package com.example.past2.applicationbusinessrules.usecases;

import org.springframework.stereotype.Component;

import com.example.past2.enterprisebusinessrules.service.JogoService;

@Component
public class ValidarJogoUC {
    private final JogoService jogoService;

    public ValidarJogoUC(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    public boolean execute(Integer codigo) {
        return jogoService.validar(codigo);
    }
}
