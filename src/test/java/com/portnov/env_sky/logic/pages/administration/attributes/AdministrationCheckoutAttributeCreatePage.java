package com.portnov.env_sky.logic.pages.administration.attributes;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdministrationCheckoutAttributeCreatePage {

    @Step("The `Add a new checkout attribute` page should be opened`")
    public void pageShouldBeOpened() {
        $("#checkout-attributes-cards").shouldBe(visible);
    }

    @Step("I type name `{name}`")
    public AdministrationCheckoutAttributeCreatePage iTypeName(String name) {
        $("#Name").setValue(name);
        return this;
    }

    @Step("I type text prompt `{textPrompt}`")
    public void iTypeTextPrompt(String textPrompt) {
        $("#TextPrompt").setValue(textPrompt);
    }
}
