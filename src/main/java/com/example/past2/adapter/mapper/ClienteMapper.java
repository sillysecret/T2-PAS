package com.example.past2.adapter.mapper;

import com.example.past2.adapter.entity.ClienteEntity;
import com.example.past2.adapter.entity.EmpresarialEntity;
import com.example.past2.adapter.entity.IndividualEntity;
import com.example.past2.domain.model.Cliente;
import com.example.past2.domain.model.Empresarial;
import com.example.past2.domain.model.Individual;

public class ClienteMapper {

    public static Cliente toModel(ClienteEntity entity) {
        if (entity instanceof IndividualEntity ind) {
            return new Individual(ind.getNumero(), ind.getNome(), ind.getEndereco(), ind.getCpf());
        } else if (entity instanceof EmpresarialEntity emp) {
            return new Empresarial(emp.getNumero(), emp.getNome(), emp.getEndereco(), emp.getNomeFantasia(), emp.getCnpj());
        }
        throw new IllegalArgumentException("Tipo de cliente desconhecido");
    }

    public static ClienteEntity toEntity(Cliente model) {
        if (model instanceof Individual ind) {
            IndividualEntity entity = new IndividualEntity();
            entity.setNumero(ind.getNumero());
            entity.setNome(ind.getNome());
            entity.setEndereco(ind.getEndereco());
            entity.setCpf(ind.getCpf());
            return entity;
        } else if (model instanceof Empresarial emp) {
            EmpresarialEntity entity = new EmpresarialEntity();
            entity.setNumero(emp.getNumero());
            entity.setNome(emp.getNome());
            entity.setEndereco(emp.getEndereco());
            entity.setNomeFantasia(emp.getNomeFantasia());
            entity.setCnpj(emp.getCnpj());
            return entity;
        }
        throw new IllegalArgumentException("Tipo de cliente desconhecido");
    }
}
