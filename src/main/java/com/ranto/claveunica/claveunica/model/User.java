package com.ranto.claveunica.claveunica.model;

public class User {
    private String sub;
    private RolUnico RolUnico;
    private Name name;

    public User() {
    }

    public User(String sub, RolUnico rolUnico, Name name) {
        this.sub = sub;
        RolUnico = rolUnico;
        this.name = name;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public RolUnico getRolUnico() {
        return RolUnico;
    }

    public void setRolUnico(RolUnico rolUnico) {
        RolUnico = rolUnico;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
