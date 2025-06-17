package com.example.past2.applicationbusinessrules;

import com.example.past2.enterprisebusinessrules.model.Aluguel;
import com.example.past2.enterprisebusinessrules.service.AluguelService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarAlugueisUseCase {

    private final AluguelService aluguelService;

    public ListarAlugueisUseCase(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    public List<Aluguel> execute() {
        return aluguelService.listarTodos();
    }
}
