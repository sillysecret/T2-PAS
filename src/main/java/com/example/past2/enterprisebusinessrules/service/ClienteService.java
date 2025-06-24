package com.example.past2.enterprisebusinessrules.service;

import com.example.past2.enterprisebusinessrules.model.Cliente;
import com.example.past2.enterprisebusinessrules.repository.IClienteRepository;
import com.example.past2.interfaceadapters.dto.ClienteDTO;
import com.example.past2.enterprisebusinessrules.entity.ClienteEntity;
import com.example.past2.enterprisebusinessrules.entity.EmpresarialEntity;
import com.example.past2.enterprisebusinessrules.entity.IndividualEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public boolean validar(Integer codigo) {
        Cliente jogo = clienteRepository.findById(codigo);
        return jogo != null;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public boolean cadastrarCliente(ClienteDTO clienteDTO) {
        try {
            ClienteEntity clienteEntity;
            if ("EMPRESARIAL".equals(clienteDTO.getTipo())) {
                clienteEntity = new EmpresarialEntity();
                ((EmpresarialEntity) clienteEntity).setCnpj(clienteDTO.getCnpj());
            } else if ("INDIVIDUAL".equals(clienteDTO.getTipo())) {
                clienteEntity = new IndividualEntity();
                ((IndividualEntity) clienteEntity).setCpf(clienteDTO.getCpf());
            } else {
                return false;
            }

            clienteEntity.setNome(clienteDTO.getNome());
            clienteEntity.setEndereco(clienteDTO.getEndereco());

            clienteRepository.save(clienteEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
