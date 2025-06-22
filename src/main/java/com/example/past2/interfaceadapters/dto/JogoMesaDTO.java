package com.example.past2.interfaceadapters.dto;

import com.example.past2.enterprisebusinessrules.model.TipoMesa;

public class JogoMesaDTO extends JogoDTO {
    TipoMesa tipo;
    Integer numeroPecas;

    public JogoMesaDTO() {

    }

    public JogoMesaDTO(Integer codigo, String nome, Double valorBase, TipoMesa tipo,
            Integer numeroPecas) {
        super(codigo, nome, valorBase);
        this.tipo = tipo;
        this.numeroPecas = numeroPecas;
    }

    public TipoMesa getTipo() {
        return tipo;
    }

    public Integer getNumeroPecas() {
        return numeroPecas;
    }

    public void setTipo(TipoMesa tipo) {
        this.tipo = tipo;
    }

    public void setNumeroPecas(Integer numeroPecas) {
        this.numeroPecas = numeroPecas;
    }

}
