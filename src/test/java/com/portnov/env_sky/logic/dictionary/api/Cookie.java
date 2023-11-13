package com.portnov.env_sky.logic.dictionary.api;

public enum Cookie {
    NOP_AUTHENTICATION(".Nop.Authentication"),
    NOP_ANTIFORGERY(".Nop.Antiforgery");

    private final String name;

    Cookie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}