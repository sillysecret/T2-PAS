package com.example.past2.adapter.mapper;


import com.example.past2.adapter.entity.AluguelEntity;
import com.example.past2.domain.model.Aluguel;

public class AluguelMapper {

    public static Aluguel toModel(AluguelEntity entity) {
        return new Aluguel(
                entity.getIdentificador(),
                entity.getDataInicial(),
                entity.getPeriodo(),
                ClienteMapper.toModel(entity.getCliente()),
                JogoMapper.toModel(entity.getJogo())
        );
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