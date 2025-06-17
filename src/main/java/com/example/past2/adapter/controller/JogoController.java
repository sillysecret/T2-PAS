package com.example.past2.adapter.controller;

import com.example.past2.domain.model.Jogo;
import com.example.past2.domain.service.JogoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/validajogo")
    public ResponseEntity<Boolean> validarJogo(@RequestBody Integer codigo) {
        boolean isValid = jogoService.validar(codigo);
        return ResponseEntity.ok(isValid);
    }
}

