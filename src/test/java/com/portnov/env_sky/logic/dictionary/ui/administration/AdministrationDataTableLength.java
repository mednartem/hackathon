package com.portnov.env_sky.logic.dictionary.ui.administration;

public enum AdministrationDataTableLength {
    SEVEN("7"),
    FIFTEEN("15"),
    TWENTY("20"),
    FIFTY("50"),
    HUNDRED("100");

    private final String value;

    AdministrationDataTableLength(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
