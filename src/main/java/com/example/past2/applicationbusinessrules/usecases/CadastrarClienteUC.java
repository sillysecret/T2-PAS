package com.example.past2.applicationbusinessrules.usecases;

import com.example.past2.enterprisebusinessrules.service.ClienteService;
import com.example.past2.interfaceadapters.dto.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class CadastrarClienteUC {
    private final ClienteService clienteService;

    public CadastrarClienteUC(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public boolean execute(ClienteDTO clienteDTO) {
        return clienteService.cadastrarCliente(clienteDTO);
    }
}
