package com.example.past2.interfaceadapters.controller;

import com.example.past2.applicationbusinessrules.usecases.*;
import com.example.past2.enterprisebusinessrules.model.Aluguel;
import com.example.past2.enterprisebusinessrules.model.Jogo;
import com.example.past2.enterprisebusinessrules.model.Cliente;
import com.example.past2.interfaceadapters.dto.AluguelDTO;
import com.example.past2.interfaceadapters.dto.ClienteDTO;
import com.example.past2.interfaceadapters.dto.JogoDTO;
import com.example.past2.interfaceadapters.dto.ValorAluguelTotalDTO;
import com.example.past2.interfaceadapters.mapper.JogoMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acmegames")
public class Controller {
    private final ListarJogosUC listarJogosUC;
    private final ListarAlugueisUC listarAlugueisUC;
    private final ListarClientesUC listarClientesUC;
    private final ValidarJogoUC validarJogoUC;
    private final CadastrarJogoUC cadastrarJogoUC;
    private final ValidarClienteUC validarClienteUC;
    private final ValidarAluguelUC validarAluguelUC;
    private final CadastrarClienteUC cadastrarClienteUC;
    private final CadastrarAluguelUC cadastrarAluguelUC;
    private final BuscarAluguelPorClienteUC buscarAluguelPorClienteUC;
    private final BuscarAluguelPorJogoUC buscarAluguelPorJogoUC;
    private final ValorJogoUC valorJogoUC;
    private final ValorAluguelUC valorAluguelUC;

    public Controller(ListarJogosUC listarJogosUC, ListarClientesUC listarClientesUC, ValidarJogoUC validarJogoUC,
            CadastrarJogoUC cadastrarJogoUC, ListarAlugueisUC listarAlugueisUC, ValidarClienteUC validarClienteUC,
            ValidarAluguelUC validarAluguelUC, CadastrarClienteUC cadastrarClienteUC,
            CadastrarAluguelUC cadastrarAluguelUC, BuscarAluguelPorClienteUC buscarAluguelPorClienteUC,
            BuscarAluguelPorJogoUC buscarAluguelPorJogoUC, ValorJogoUC valorJogoUC, ValorAluguelUC valorAluguelUC) {
        this.listarJogosUC = listarJogosUC;
        this.listarClientesUC = listarClientesUC;
        this.validarJogoUC = validarJogoUC;
        this.cadastrarJogoUC = cadastrarJogoUC;
        this.listarAlugueisUC = listarAlugueisUC;
        this.validarClienteUC = validarClienteUC;
        this.validarAluguelUC = validarAluguelUC;
        this.cadastrarClienteUC = cadastrarClienteUC;
        this.cadastrarAluguelUC = cadastrarAluguelUC;
        this.buscarAluguelPorClienteUC = buscarAluguelPorClienteUC;
        this.buscarAluguelPorJogoUC = buscarAluguelPorJogoUC;
        this.valorJogoUC = valorJogoUC;
        this.valorAluguelUC = valorAluguelUC;
    }

    @GetMapping("/cadastro/listajogos")
    public ResponseEntity<List<Jogo>> listarJogos() {
        List<Jogo> jogos = listarJogosUC.execute();
        return ResponseEntity.ok(jogos);
    }

    @GetMapping("/cadastro/listaalugueis")
    public ResponseEntity<List<Aluguel>> listarAlugueis() {
        List<Aluguel> alugueis = listarAlugueisUC.execute();
        return ResponseEntity.ok(alugueis);
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

    @PostMapping("/validacliente")
    public ResponseEntity<Boolean> validaCliente(@RequestBody Integer numero) {
        boolean resultado = validarClienteUC.execute(numero);

        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/validaaluguel")
    public ResponseEntity<Boolean> validaAluguel(@RequestBody Integer codigo) {
        boolean resultado = validarAluguelUC.execute(codigo);

        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/cadastro/listaclientes")
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> cliente = listarClientesUC.execute();
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/cadastro/cadcliente")
    public boolean cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        return cadastrarClienteUC.execute(clienteDTO);
    }

    @PostMapping("/cadastro/cadaluguel")
    public boolean cadastrarAluguel(@RequestBody AluguelDTO dto) {
        return cadastrarAluguelUC.execute(dto);
    }

    @GetMapping("/cliente/aluguel/{numero}")
    public List<Aluguel> listarAlugueisPorCliente(@PathVariable Integer numero) {
        return buscarAluguelPorClienteUC.execute(numero);
    }

    @GetMapping("/jogo/aluguel/{codigo}")
    public List<Aluguel> listarAlugueisPorJogo(@PathVariable Integer codigo) {
        return buscarAluguelPorJogoUC.execute(codigo);
    }

    @GetMapping("/aluguel/valorjogo/{codigo}")
    public Double obterPrecoDoJogo(@PathVariable Integer codigo) {
        return valorJogoUC.execute(codigo);
    }

    @GetMapping("/aluguel/valorfinal/{numero}")
    public ValorAluguelTotalDTO obterPrecoDoAlugel(@PathVariable Integer numero) {
        return valorAluguelUC.execute(numero);
    }
}
