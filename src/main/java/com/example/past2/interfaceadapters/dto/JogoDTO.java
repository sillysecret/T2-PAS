package com.example.past2.interfaceadapters.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoJogo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = JogoEletronicoDTO.class, name = "ELETRONICO"),
        @JsonSubTypes.Type(value = JogoMesaDTO.class, name = "MESA")
})
public abstract class JogoDTO {
    Integer codigo;
    String nome;
    Double valorBase;

    protected JogoDTO() {
    }

    protected JogoDTO(Integer codigo, String nome, Double valorBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorBase = valorBase;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Double getValorBase() {
        return valorBase;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorBase(Double valorBase) {
        this.valorBase = valorBase;
    }
}
