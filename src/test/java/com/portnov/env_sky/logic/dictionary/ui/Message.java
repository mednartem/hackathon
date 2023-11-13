package com.portnov.env_sky.logic.dictionary.ui;

public enum Message {
    YOUR_REGISTRATION_COMPLETED("Your registration completed");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
