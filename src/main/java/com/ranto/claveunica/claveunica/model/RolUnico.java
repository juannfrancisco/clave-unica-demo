package com.ranto.claveunica.claveunica.model;


public class RolUnico {

    private String DV;
    private Integer numero;
    private String tipo;


    public RolUnico() {
    }

    public RolUnico(String DV, Integer numero, String tipo) {
        this.DV = DV;
        this.numero = numero;
        this.tipo = tipo;
    }

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
