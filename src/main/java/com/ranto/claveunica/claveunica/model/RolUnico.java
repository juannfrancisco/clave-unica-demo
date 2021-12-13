package com.ranto.claveunica.claveunica.model;

import io.swagger.models.auth.In;

public class RolUnico {

    private String DV;
    private Integer numero;
    private String tipo;


    public String getDV() {
        return DV;
    }

    public void setDV(String DV) {
        this.DV = DV;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
