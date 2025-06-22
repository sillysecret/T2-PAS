package com.example.past2.interfaceadapters.controller;

import com.example.past2.applicationbusinessrules.usecases.ListarAlugueisUC;
import com.example.past2.enterprisebusinessrules.model.Aluguel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {
    private final ListarAlugueisUC listarAlugueisUC;

    public AluguelController(ListarAlugueisUC listarAlugueisUC) {
        this.listarAlugueisUC = listarAlugueisUC;
    }

    @GetMapping
    public ResponseEntity<List<Aluguel>> listarJogos() {
        List<Aluguel> jogos = listarAlugueisUC.execute();
        return ResponseEntity.ok(jogos);
    }

    // @GetMapping("/jogo/aluguel/{codigo}")
    // public ResponseEntity<List<Aluguel>> listarAlugueisPorJogo(@PathVariable
    // Integer codigo) {
    // List<Aluguel> alugueis = listarAlugueisPorJogoUC.execute(codigo);

    // return ResponseEntity.ok(alugueis);
    // }

    /*
     * Endpoint: POST /acmegames/validaaluguel
     * Descrição Retorna se o aluguel é válido
     * Corpo da
     * requisição
     * {identificador do aluguel}
     * JSON
     * resposta
     * Booleano: true ou false
     * 
     * Endpoint: GET /acmegames/cadastro/listaalugueis
     * Descrição Lista com todos os alugueis cadastrados
     * Parâmetros
     * de entrada
     * Nenhum
     * JSON
     * resposta
     * [{identificador,dataInicial,... }, ..., valor final ]
     * 
     * Endpoint: GET /acmegames/aluguel/valorfinal/:identificador
     * Descrição Retorna o valor final de um de aluguel
     * Parâmetros
     * de entrada
     * identificador do aluguel
     * JSON
     * resposta
     * [{código do jogo, código do aluguel, número cliente, custo}, ... ]
     * 
     * Endpoint: GET /acmegames/aluguel/valorjogo/:codigo
     * Descrição Retorna o valor de aluguel de um jogo
     * Parâmetros
     * de entrada
     * código do jogo
     * JSON
     * resposta
     * [{código do jogo, código do aluguel, número cliente, custo}, ... ]
     */
}
