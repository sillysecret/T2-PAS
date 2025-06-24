package com.example.past2.applicationbusinessrules.usecases;

import com.example.past2.enterprisebusinessrules.service.JogoService;
import org.springframework.stereotype.Component;

@Component
public class ValorJogoUC {
    private final JogoService jogoService;

    public ValorJogoUC(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    public Double execute(Integer codigo) {
        return jogoService.obterValorJogoPorCodigo(codigo);
    }
}
