package com.portnov.env_sky.logic.dictionary.ui;

public enum ShoesSize {
    EIGHTH("8"),
    NINE("9"),
    TEN("10"),
    ELEVEN("11");

    private final String value;

    ShoesSize(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
