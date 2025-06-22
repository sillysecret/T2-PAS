package com.example.past2.interfaceadapters.dto;

import com.example.past2.enterprisebusinessrules.model.TipoEletronico;

public class JogoEletronicoDTO extends JogoDTO {
    TipoEletronico tipo;
    String plataforma;

    public JogoEletronicoDTO() {
        super();
    }

    public JogoEletronicoDTO(Integer codigo, String nome, Double valorBase, TipoEletronico tipo,
            String plataforma) {
        super(codigo, nome, valorBase);
        this.tipo = tipo;
        this.plataforma = plataforma;
    }

    public TipoEletronico getTipo() {
        return tipo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setTipo(TipoEletronico tipo) {
        this.tipo = tipo;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}
