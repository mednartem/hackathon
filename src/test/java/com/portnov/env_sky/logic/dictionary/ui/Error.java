package com.portnov.env_sky.logic.dictionary.ui;

public enum Error {
    PLEASE_ENTER_YOUR_EMAIL("Please enter your email"),
    WRONG_EMAIL("Wrong email"),
    MUST_HAVE_AT_LEAST_SIX_CHARACTERS("must meet the following rules:\nmust have at least 6 characters"),
    FIRST_NAME_IS_REQUIRED("First name is required."),
    LAST_NAME_IS_REQUIRED("Last name is required."),
    EMAIL_IS_REQUIRED("Email is required."),
    PASSWORD_IS_REQUIRED("Password is required."),
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
