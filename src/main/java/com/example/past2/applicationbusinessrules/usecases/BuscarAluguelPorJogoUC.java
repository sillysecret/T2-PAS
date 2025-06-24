package com.example.past2.applicationbusinessrules.usecases;

import com.example.past2.enterprisebusinessrules.model.Aluguel;
import com.example.past2.enterprisebusinessrules.service.AluguelService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarAluguelPorJogoUC {
    private final AluguelService aluguelService;

    public BuscarAluguelPorJogoUC(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    public List<Aluguel> execute(int jogoId) {
        return aluguelService.buscarAluguelPorJogo(jogoId);
    }
}
