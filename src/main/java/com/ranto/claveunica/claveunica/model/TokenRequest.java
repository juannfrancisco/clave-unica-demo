package com.ranto.claveunica.claveunica.model;

public class TokenRequest {

    private String cliend_id;
    private String cliend_secret;
    private String redirect_uri;
    private String grant_type;
    private String code;
    private String state;


    public String getCliend_id() {
        return cliend_id;
    }

    public void setCliend_id(String cliend_id) {
        this.cliend_id = cliend_id;
    }

    public String getCliend_secret() {
        return cliend_secret;
    }

    public void setCliend_secret(String cliend_secret) {
        this.cliend_secret = cliend_secret;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
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
}
