package com.example.past2.applicationbusinessrules.usecases;

import com.example.past2.enterprisebusinessrules.service.ClienteService;
import org.springframework.stereotype.Component;

@Component
public class ValidarClienteUC {
    private final ClienteService clienteService;

    public ValidarClienteUC(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public boolean execute(Integer codigo) {
        return clienteService.validar(codigo);
    }
}
