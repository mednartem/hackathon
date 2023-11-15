package com.portnov.env_sky.logic.dictionary.ui.administration;

public enum AdministrationAlertNotification {
    THE_NEW_CATEGORY_HAS_BEEN_ADDED_SUCCESSFULLY("The new category has been added successfully."),
    THE_CATEGORY_HAS_BEEN_DELETED_SUCCESSFULLY(" The category has been deleted successfully."),
    THE_NEW_PRODUCT_HAS_BEEN_ADDED_SUCCESSFULLY("The new product has been added successfully."),
    THE_PRODUCT_HAS_BEEN_DELETED_SUCCESSFULLY("The product has been deleted successfully.");

    private final String value;

    AdministrationAlertNotification(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
