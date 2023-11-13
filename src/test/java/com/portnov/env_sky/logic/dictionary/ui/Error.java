package com.portnov.env_sky.logic.dictionary.ui;

public enum Error {
    PLEASE_ENTER_YOUR_EMAIL("Please enter your email"),
    LOGIN_UNSUCCESSFUL_INCORRECT_CREDENTIALS("Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect"),
    LOGIN_UNSUCCESSFUL_NO_CUSTOMER_ACCOUNT_FOUND("Login was unsuccessful. Please correct the errors and try again. No customer account found");

    private final String value;

    Error(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
