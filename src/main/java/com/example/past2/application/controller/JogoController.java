package com.example.past2.application.controller;

import com.example.past2.application.service.JogoService;
import com.example.past2.domain.model.Jogo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    private final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> listarJogos() {
        List<Jogo> jogos = jogoService.listarTodos();
        return ResponseEntity.ok(jogos);
    }
}

