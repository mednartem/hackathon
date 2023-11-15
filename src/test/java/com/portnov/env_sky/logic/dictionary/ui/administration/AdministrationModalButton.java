package com.portnov.env_sky.logic.dictionary.ui.administration;

public enum AdministrationModalButton {
    YES(" Yes "),
    DELETE(" Delete ");
    private final String value;

    AdministrationModalButton(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
