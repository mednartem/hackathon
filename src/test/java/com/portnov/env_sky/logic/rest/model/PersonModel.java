package com.portnov.env_sky.logic.rest.model;

public class PersonModel {
    private String email;
    private String password;
    private String verificationToken;
    private String cookieNopAntiforgery;
    private String cookieNopAuthentication;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public String getCookieNopAntiforgery() {
        return cookieNopAntiforgery;
    }

    public void setCookieNopAntiforgery(String cookieNopAntiforgery) {
        this.cookieNopAntiforgery = cookieNopAntiforgery;
    }

    public String getCookieNopAuthentication() {
        return cookieNopAuthentication;
    }

    public void setCookieNopAuthentication(String cookieNopAuthentication) {
        this.cookieNopAuthentication = cookieNopAuthentication;
    }
}
