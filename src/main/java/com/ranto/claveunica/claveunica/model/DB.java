package com.ranto.claveunica.claveunica.model;

public class DB {

    private String run;
    private String password;
    private String code;
    private String state;
    private TokenResponse json;
    private User user;


    public DB() {
    }

    public DB(String run, String password, String code, String state, TokenResponse json, User user) {
        this.run = run;
        this.password = password;
        this.code = code;
        this.state = state;
        this.json = json;
        this.user = user;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TokenResponse getJson() {
        return json;
    }

    public void setJson(TokenResponse json) {
        this.json = json;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
