package com.portnov.env_sky.logic.pages.administration.products;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AdministrationProductCreatePage {

    @Step("`Create product` page should be opened`")
    public void pageShouldBeOpened() {
        $("#product-cards").shouldBe(visible);
    }

    @Step("I type name `{name}`")
    public AdministrationProductCreatePage iTypeName(String name) {
        $("#Name").setValue(name);
        return this;
    }

    @Step("I type short description `{description}`")
    public void iTypeShortDescription(String description) {
        $("#ShortDescription").setValue(description);
    }
}
