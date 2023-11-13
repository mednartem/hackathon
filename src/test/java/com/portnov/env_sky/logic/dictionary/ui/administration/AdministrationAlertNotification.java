package com.portnov.env_sky.logic.dictionary.ui.administration;

public enum AdministrationAlertNotification {
    THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY("The new category has been added successfully.");

    private final String value;

    AdministrationAlertNotification(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}