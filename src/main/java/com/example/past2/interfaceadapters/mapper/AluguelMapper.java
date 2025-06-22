package com.example.past2.interfaceadapters.mapper;

import com.example.past2.enterprisebusinessrules.model.Aluguel;
import com.example.past2.interfaceadapters.entity.AluguelEntity;

public class AluguelMapper {

    public static Aluguel toModel(AluguelEntity entity) {
        return new Aluguel(
                entity.getIdentificador(),
                entity.getDataInicial(),
                entity.getPeriodo(),
                ClienteMapper.toModel(entity.getCliente()),
                JogoMapper.entityToModel(entity.getJogo()));
    }

    public static AluguelEntity toEntity(Aluguel model) {
        AluguelEntity entity = new AluguelEntity();
        entity.setIdentificador(model.getIdentificador());
        entity.setDataInicial(model.getDataInicial());
        entity.setPeriodo(model.getPeriodo());
        entity.setCliente(ClienteMapper.toEntity(model.getCliente()));
        entity.setJogo(JogoMapper.toEntity(model.getJogo()));
        return entity;
    }
}
