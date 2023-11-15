package com.portnov.env_sky.logic.pages.administration.attributes;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdministrationProductAttributeCreatePage {

    @Step("The `Add a new product attribute` page should be opened`")
    public void pageShouldBeOpened() {
        $("#product-attribute-cards").shouldBe(visible);
    }

    @Step("I type name `{name}`")
    public AdministrationProductAttributeCreatePage iTypeName(String name) {
        $("#Name").setValue(name);
        return this;
    }

    @Step("I type description `{description}`")
    public void iTypeDescription(String description) {
        Selenide.switchTo().frame($("#Description_ifr"));
        $("#tinymce").setValue(description);
        Selenide.switchTo().defaultContent();
    }
}
