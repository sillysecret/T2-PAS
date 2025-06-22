package com.example.past2.applicationbusinessrules.usecases;

import org.springframework.stereotype.Component;

import com.example.past2.enterprisebusinessrules.model.Jogo;
import com.example.past2.enterprisebusinessrules.service.JogoService;

@Component
public class CadastrarJogoUC {
    private final JogoService jogoService;

    public CadastrarJogoUC(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    public boolean execute(Jogo jogo) {
        return jogoService.cadastrar(jogo);
    }
}
