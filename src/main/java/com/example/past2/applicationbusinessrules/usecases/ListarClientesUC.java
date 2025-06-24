package com.example.past2.applicationbusinessrules.usecases;

import com.example.past2.enterprisebusinessrules.model.Aluguel;
import com.example.past2.enterprisebusinessrules.model.Cliente;
import com.example.past2.enterprisebusinessrules.service.AluguelService;
import com.example.past2.enterprisebusinessrules.service.ClienteService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarClientesUC {

    private final ClienteService clienteService;

    public ListarClientesUC(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<Cliente> execute() {
        return clienteService.listarTodos();
    }
}
