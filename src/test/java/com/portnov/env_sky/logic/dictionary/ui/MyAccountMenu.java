package com.portnov.env_sky.logic.dictionary.ui;

public enum MyAccountMenu {
    CUSTOMER_INFO("Customer info"),
    ADDRESSES("Addresses"),
    ORDERS("Orders"),
    DOWNLOADABLE_PRODUCTS("Downloadable products"),
    BACK_IN_STOCK_SUBSCRIPTIONS("Back in stock subscriptions"),
    REWARD_POINTS("Reward points"),
    CHANGE_PASSWORD("Change password"),
    MY_PRODUCT_REVIEWS("My product reviews");

    private final String value;

    MyAccountMenu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
