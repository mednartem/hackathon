package com.portnov.env_sky.logic.pages;

import com.codeborne.selenide.SelenideElement;
import com.portnov.env_sky.logic.helpers.WebElementWork;
import com.portnov.env_sky.logic.rest.model.ProductModel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryPage {

    @Step("The `Category` page should be opened`")
    public CategoryPage pageShouldBeOpened() {
        $(".category-page").shouldBe(visible);
        return this;
    }


    @Step("I open random product, remember title and price {productModel}")
    public void iOpenRandomItem(ProductModel productModel) {
        SelenideElement el = WebElementWork.getRandomElementFromList(
                $$(".product-item").shouldHave(sizeGreaterThan(0))
        );

        productModel.setTitle(el.$(".product-title").getText());
        productModel.setPrice(el.$(".actual-price").getText());

        el.click();
    }
}
