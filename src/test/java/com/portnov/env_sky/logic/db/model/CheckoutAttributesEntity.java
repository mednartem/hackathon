package com.portnov.env_sky.logic.db.model;

public class CheckoutAttributesEntity {
    private int id;
    private String name;
    private String textPrompt;
    private int isRequired;
    private int shippableProductRequired;
    private int isTaxExempt;
    private int taxCategoryId;
    private int attributeControlTypeId;
    private int displayOrder;
    private int limitedToStores;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextPrompt() {
        return textPrompt;
    }

    public void setTextPrompt(String textPrompt) {
        this.textPrompt = textPrompt;
    }

    public int getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(int isRequired) {
        this.isRequired = isRequired;
    }

    public int getShippableProductRequired() {
        return shippableProductRequired;
    }

    public void setShippableProductRequired(int shippableProductRequired) {
        this.shippableProductRequired = shippableProductRequired;
    }

    public int getIsTaxExempt() {
        return isTaxExempt;
    }

    public void setIsTaxExempt(int isTaxExempt) {
        this.isTaxExempt = isTaxExempt;
    }

    public int getTaxCategoryId() {
        return taxCategoryId;
    }

    public void setTaxCategoryId(int taxCategoryId) {
        this.taxCategoryId = taxCategoryId;
    }

    public int getAttributeControlTypeId() {
        return attributeControlTypeId;
    }

    public void setAttributeControlTypeId(int attributeControlTypeId) {
        this.attributeControlTypeId = attributeControlTypeId;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public int getLimitedToStores() {
        return limitedToStores;
    }

    public void setLimitedToStores(int limitedToStores) {
        this.limitedToStores = limitedToStores;
    }
}
