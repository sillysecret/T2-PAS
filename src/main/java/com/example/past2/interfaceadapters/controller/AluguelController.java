package com.example.past2.interfaceadapters.controller;

import com.example.past2.applicationbusinessrules.ListarAlugueisUseCase;
import com.example.past2.enterprisebusinessrules.model.Aluguel;
import com.example.past2.enterprisebusinessrules.model.Jogo;
import com.example.past2.enterprisebusinessrules.service.AluguelService;
import com.example.past2.enterprisebusinessrules.service.JogoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {
    private final ListarAlugueisUseCase listarAlugueisUseCase;

    public AluguelController(ListarAlugueisUseCase listarAlugueisUseCase) {
        this.listarAlugueisUseCase = listarAlugueisUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Aluguel>> listarJogos() {
        List<Aluguel> jogos = listarAlugueisUseCase.execute();
        return ResponseEntity.ok(jogos);
    }
}
