package com.ranto.claveunica.claveunica.model;

public class User {
    private String sub;
    private RolUnico RolUnico;
    private Name name;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public com.ranto.claveunica.claveunica.model.RolUnico getRolUnico() {
        return RolUnico;
    }

    public void setRolUnico(com.ranto.claveunica.claveunica.model.RolUnico rolUnico) {
        RolUnico = rolUnico;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
