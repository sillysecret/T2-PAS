package com.example.past2.interfaceadapters.controller;

import com.example.past2.applicationbusinessrules.usecases.CadastrarJogoUC;
import com.example.past2.applicationbusinessrules.usecases.ListarJogosUC;
import com.example.past2.applicationbusinessrules.usecases.ValidarJogoUC;
import com.example.past2.enterprisebusinessrules.model.Jogo;
import com.example.past2.interfaceadapters.dto.JogoDTO;
import com.example.past2.interfaceadapters.mapper.JogoMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acmegames")
public class JogoController {
    private final ListarJogosUC listarJogosUC;
    private final ValidarJogoUC validarJogoUC;
    private final CadastrarJogoUC cadastrarJogoUC;

    public JogoController(ListarJogosUC listarJogosUC, ValidarJogoUC validarJogoUC,
            CadastrarJogoUC cadastrarJogoUC) {
        this.listarJogosUC = listarJogosUC;
        this.validarJogoUC = validarJogoUC;
        this.cadastrarJogoUC = cadastrarJogoUC;
    }

    @GetMapping("/cadastro/listajogos")
    public ResponseEntity<List<Jogo>> listarJogos() {
        List<Jogo> jogos = listarJogosUC.execute();
        return ResponseEntity.ok(jogos);
    }

    @PostMapping("/validajogo")
    public ResponseEntity<Boolean> validarJogo(@RequestBody Integer codigo) {
        boolean isValid = validarJogoUC.execute(codigo);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/cadastro/cadjogo")
    public ResponseEntity<Boolean> cadastrarJogo(@RequestBody JogoDTO jogoDto) {
        Jogo jogo = JogoMapper.dtoToModel(jogoDto);

        boolean resultado = cadastrarJogoUC.execute(jogo);

        return ResponseEntity.ok(resultado);
    }
}
