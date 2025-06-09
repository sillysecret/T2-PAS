package com.example.past2.infrastructure.mapper;

import com.example.past2.domain.model.Jogo;
import com.example.past2.domain.model.JogoEletronico;
import com.example.past2.domain.model.JogoMesa;
import com.example.past2.infrastructure.persistence.entity.JogoEletronicoEntity;
import com.example.past2.infrastructure.persistence.entity.JogoEntity;
import com.example.past2.infrastructure.persistence.entity.JogoMesaEntity;

public class JogoMapper {

    public static Jogo toModel(JogoEntity entity) {
        if (entity instanceof JogoEletronicoEntity e) {
            return new JogoEletronico(e.getCodigo(), e.getNome(), e.getValorBase(), e.getTipo(), e.getPlataforma());
        } else if (entity instanceof JogoMesaEntity m) {
            return new JogoMesa(m.getCodigo(), m.getNome(), m.getValorBase(), m.getTipo(), m.getNumeroPecas());
        }
        throw new IllegalArgumentException("Tipo de jogo desconhecido");
    }

    public static JogoEntity toEntity(Jogo model) {
        if (model instanceof JogoEletronico e) {
            JogoEletronicoEntity entity = new JogoEletronicoEntity();
            entity.setCodigo(e.getCodigo());
            entity.setNome(e.getNome());
            entity.setValorBase(e.getValorBase());
            entity.setTipo(e.getTipo());
            entity.setPlataforma(e.getPlataforma());
            return entity;
        } else if (model instanceof JogoMesa m) {
            JogoMesaEntity entity = new JogoMesaEntity();
            entity.setCodigo(m.getCodigo());
            entity.setNome(m.getNome());
            entity.setValorBase(m.getValorBase());
            entity.setTipo(m.getTipo());
            entity.setNumeroPecas(m.getNumeroPecas());
            return entity;
        }
        throw new IllegalArgumentException("Tipo de jogo desconhecido");
    }
}
