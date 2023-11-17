package com.portnov.env_sky.logic.rest.model;

import com.portnov.env_sky.logic.dictionary.ui.ShoesColor;
import com.portnov.env_sky.logic.dictionary.ui.ShoesSize;

public class ProductModel {
    private String title;
    private String price;
    private String sku;
    private String quantity;
    private ShoesSize shoesSize;
    private ShoesColor shoesColor;

    public String getTitle() {
        return title;
    }

    public ProductModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public ProductModel setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public ProductModel setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public ProductModel setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public ShoesSize getShoesSize() {
        return shoesSize;
    }

    public ProductModel setShoesSize(ShoesSize shoesSize) {
        this.shoesSize = shoesSize;
        return this;
    }

    public ShoesColor getShoesColor() {
        return shoesColor;
    }

    public ProductModel setShoesColor(ShoesColor shoesColor) {
        this.shoesColor = shoesColor;
        return this;
    }
}
