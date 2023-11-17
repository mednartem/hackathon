package com.portnov.env_sky.logic.dictionary.ui;

public enum MenuHeader {
    APPAREL("Apparel "),
    SHOES("Shoes ");

    private final String value;

    MenuHeader(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
