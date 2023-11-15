package com.portnov.env_sky.logic.dictionary.ui.administration;

public enum AdministrationMenu {
    CATALOG("Catalog "),
    CATEGORIES("Categories"),
    PRODUCTS("Products"),
    MANUFACTURERS("Manufacturers"),
    ATTRIBUTES("Attributes "),
    PRODUCT_ATTRIBUTES("Product attributes");

    private final String value;

    AdministrationMenu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
