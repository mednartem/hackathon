package com.portnov.env_sky.logic.dictionary.ui;

public enum ShoesColor {
    RED("Red"),
    BLUE("Blue"),
    SILVER("Silver");

    private final String value;

    ShoesColor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
