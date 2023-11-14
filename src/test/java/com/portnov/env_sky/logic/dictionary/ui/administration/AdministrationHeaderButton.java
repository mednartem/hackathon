package com.portnov.env_sky.logic.dictionary.ui.administration;

public enum AdministrationHeaderButton {
    ADD_NEW(" Add new "),
    SAVE(" Save "),
    SAVE_AND_CONTINUE_EDIT(" Save and Continue Edit "),
    PREVIEW(" Preview "),
    DELETE(" Delete ");
    private final String value;

    AdministrationHeaderButton(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
