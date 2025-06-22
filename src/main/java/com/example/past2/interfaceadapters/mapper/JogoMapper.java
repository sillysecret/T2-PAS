package com.example.past2.interfaceadapters.mapper;

import com.example.past2.interfaceadapters.dto.JogoDTO;
import com.example.past2.interfaceadapters.dto.JogoEletronicoDTO;
import com.example.past2.interfaceadapters.dto.JogoMesaDTO;
import com.example.past2.interfaceadapters.entity.JogoEletronicoEntity;
import com.example.past2.interfaceadapters.entity.JogoEntity;
import com.example.past2.interfaceadapters.entity.JogoMesaEntity;
import com.example.past2.enterprisebusinessrules.model.Jogo;
import com.example.past2.enterprisebusinessrules.model.JogoEletronico;
import com.example.past2.enterprisebusinessrules.model.JogoMesa;

public class JogoMapper {

    public static Jogo dtoToModel(JogoDTO dto) {
        if (dto instanceof JogoEletronicoDTO e) {
            return new JogoEletronico(e.getCodigo(), e.getNome(), e.getValorBase(), e.getTipo(), e.getPlataforma());
        } else if (dto instanceof JogoMesaDTO m) {
            return new JogoMesa(m.getCodigo(), m.getNome(), m.getValorBase(), m.getTipo(), m.getNumeroPecas());
        }
        throw new IllegalArgumentException("Tipo de jogo desconhecido");
    }

    public static Jogo entityToModel(JogoEntity entity) {
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
