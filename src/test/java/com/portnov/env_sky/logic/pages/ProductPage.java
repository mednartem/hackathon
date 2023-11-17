package com.portnov.env_sky.logic.pages;

import com.portnov.env_sky.logic.dictionary.ui.ShoesColor;
import com.portnov.env_sky.logic.dictionary.ui.ShoesSize;
import com.portnov.env_sky.logic.rest.model.ProductModel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    @Step("The `Product` page should be opened`")
    public ProductPage pageShouldBeOpened() {
        $(".product-details-page").shouldBe(visible);
        return this;
    }

    @Step("Opened product should be {productModel}")
    public void openedProductShouldBe(ProductModel productModel) {
        $(".product-name").shouldHave(exactText(productModel.getTitle()));
        $(".product-price").shouldHave(exactText(productModel.getPrice()));
    }

    @Step("I select shoes size `{size}`")
    public ProductPage iSelectSize(ShoesSize size) {
        $(".attributes #product_attribute_9").selectOption(size.getValue());
        return this;
    }

    @Step("I click shoes color `{color}`")
    public ProductPage iClickColor(ShoesColor color) {
        $(String.format(".attributes [title=%s]", color.getValue())).click();
        return this;
    }

    @Step("I click `Add to cart` button")
    public ProductPage iClickAddToCartBtn() {
        $("[id*=add-to-cart-button]").click();
        return this;
    }
}
