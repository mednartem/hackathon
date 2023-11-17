package com.portnov.env_sky.logic.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.portnov.env_sky.logic.dictionary.ui.ProductShoes;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    private final ElementsCollection elListProducts = $$(".cart tbody tr");

    @Step("The `Shopping cart` page should be opened`")
    public CartPage pageShouldBeOpened() {
        $(".shopping-cart-page").shouldBe(visible);
        return this;
    }

    @Step("Number positions should be `{number}` in the cart")
    public CartPage numberPositionsShouldBe(int number) {
        elListProducts.shouldHave(size(number));
        return this;
    }

    @Step("First product should be {productShoes}")
    public CartPage firstProductShouldBe(ProductShoes productShoes, int quantity) {
        String price = "$" + productShoes.getPrice();
        SelenideElement el = elListProducts.shouldHave(sizeGreaterThan(0)).first();
        el.$(".sku-number").shouldHave(text(productShoes.getSku()));
        el.$(".product-name").shouldHave(text(productShoes.getTitle()));
        el.$(".attributes").shouldHave(
                text(productShoes.getShoesSize().getValue()), text(productShoes.getShoesColor().getValue())
        );
        el.$(".qty-input").shouldHave(value(String.valueOf(quantity)));
        el.$(".product-unit-price").shouldHave(text(price));
        el.$(".product-subtotal").shouldHave(text(price));
        return this;
    }
}
