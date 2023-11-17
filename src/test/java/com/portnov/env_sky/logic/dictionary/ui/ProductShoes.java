package com.portnov.env_sky.logic.dictionary.ui;


public enum ProductShoes {
    ADIDAS_CONSORTIUM_CAMPUS_80S_RUNNING_SHOES(
            "adidas Consortium Campus 80s Running Shoes",
            "/adidas-consortium-campus-80s-running-shoes",
            27.56,
            "AD_C80_RS",
            ShoesSize.NINE,
            ShoesColor.RED
    );

    private final String title;
    private final String slug;
    private final double price;
    private final String sku;
    private final ShoesSize shoesSize;
    private final ShoesColor shoesColor;

    ProductShoes(String title, String slug, double price, String sku, ShoesSize shoesSize, ShoesColor shoesColor) {
        this.title = title;
        this.slug = slug;
        this.price = price;
        this.sku = sku;
        this.shoesSize = shoesSize;
        this.shoesColor = shoesColor;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public double getPrice() {
        return price;
    }

    public String getSku() {
        return sku;
    }

    public ShoesSize getShoesSize() {
        return shoesSize;
    }

    public ShoesColor getShoesColor() {
        return shoesColor;
    }
}
