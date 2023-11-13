package com.portnov.env_sky.logic.dictionary.ui;

public enum BarNotification {
    EMAIL_NOT_FOUND("Email not found."),
    EMAIL_WITH_INSTRUCTIONS_HAS_BEEN_SENT_TO_YOU("Email with instructions has been sent to you.");

    private final String value;

    BarNotification(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
