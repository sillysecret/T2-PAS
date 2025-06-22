package com.example.past2.applicationbusinessrules.usecases;

import org.springframework.stereotype.Component;

import com.example.past2.enterprisebusinessrules.model.Jogo;
import com.example.past2.enterprisebusinessrules.service.JogoService;

import java.util.List;

@Component
public class ListarJogosUC {
    private final JogoService jogoService;

    public ListarJogosUC(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    public List<Jogo> execute() {
        return jogoService.listarTodos();
    }
}
