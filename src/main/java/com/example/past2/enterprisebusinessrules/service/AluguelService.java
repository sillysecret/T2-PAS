package com.example.past2.enterprisebusinessrules.service;

import com.example.past2.enterprisebusinessrules.model.*;
import com.example.past2.enterprisebusinessrules.repository.IAluguelRepository;

import com.example.past2.enterprisebusinessrules.repository.IClienteRepository;
import com.example.past2.enterprisebusinessrules.repository.IJogoRepository;
import com.example.past2.interfaceadapters.dto.AluguelDTO;
import com.example.past2.interfaceadapters.dto.ValorAluguelTotalDTO;
import com.example.past2.enterprisebusinessrules.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {
    private final IAluguelRepository aluguelRepository;
    private final IClienteRepository clienteRepository;
    private final IJogoRepository jogoRepository;

    public AluguelService(IAluguelRepository aluguelRepository, IClienteRepository clienteRepository, IJogoRepository jogoRepository) {
        this.aluguelRepository = aluguelRepository;
        this.clienteRepository = clienteRepository;
        this.jogoRepository = jogoRepository;
    }

    public List<Aluguel> listarTodos() {
        return aluguelRepository.findAll();
    }

    public boolean validar(int codigo) {
        Aluguel aluguel = aluguelRepository.findById(codigo);
        return aluguel != null;
    }

    public boolean cadastrarAluguel(AluguelDTO dto) {
        Optional<ClienteEntity> clienteOpt = clienteRepository.findEntityById(dto.getNumeroCliente());
        Optional<JogoEntity> jogoOpt = jogoRepository.findEntityById(dto.getCodigoJogo());

        if (clienteOpt.isEmpty() || jogoOpt.isEmpty()) {
            return false;
        }

        AluguelEntity aluguel = new AluguelEntity();
        aluguel.setDataInicial(dto.getDataInicial());
        aluguel.setPeriodo(dto.getPeriodo());
        aluguel.setCliente(clienteOpt.get());
        aluguel.setJogo(jogoOpt.get());

        aluguelRepository.save(aluguel);
        return true;
    }

    public List<Aluguel> buscarAluguelPorCliente(int clienteId) {
        return aluguelRepository.findByClienteId(clienteId);
    }

    public List<Aluguel> buscarAluguelPorJogo(int jogoId) {
        return aluguelRepository.findByJogoId(jogoId);
    }

    public ValorAluguelTotalDTO buscaValorDeAluguel(int alugelId){
        Aluguel aluguel = aluguelRepository.findById(alugelId);
        Cliente cliente = aluguel.getCliente();
        Jogo jogo = aluguel.getJogo();
        int periodo = aluguel.getPeriodo();
        Double fator;
        Double valorJogo = jogo.getValorAluguel();

        if (cliente instanceof Individual) {
            if (periodo < 7) {
                fator = 0.90;
            } else if (periodo <= 14) {
                fator = 0.80;
            } else {
                fator = 0.75;
            }
        } else if (cliente instanceof Empresarial) {
            if (jogo instanceof JogoMesa) {
                fator = 0.85;
            } else {
                fator = 1.00;
            }
        } else {
            fator = 1.0;
        }

        ValorAluguelTotalDTO valorAluguelTotal = new ValorAluguelTotalDTO();
        valorAluguelTotal.setValue(valorJogo * periodo * fator);
        valorAluguelTotal.setAluguelId(aluguel.getIdentificador());
        valorAluguelTotal.setJogoId(jogo.getCodigo());
        valorAluguelTotal.setClienteId(cliente.getNumero());
        return valorAluguelTotal;
    }
}
