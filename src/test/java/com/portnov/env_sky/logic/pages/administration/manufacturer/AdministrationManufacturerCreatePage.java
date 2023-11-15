package com.portnov.env_sky.logic.pages.administration.manufacturer;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdministrationManufacturerCreatePage {

    @Step("`Create manufacturer` page should be opened`")
    public void pageShouldBeOpened() {
        $("#manufacturer-cards").shouldBe(visible);
    }

    @Step("I type name `{name}`")
    public AdministrationManufacturerCreatePage iTypeName(String name) {
        $("#Name").setValue(name);
        return this;
    }

    @Step("I type description `{description}`")
    public AdministrationManufacturerCreatePage iTypeDescription(String description) {
        Selenide.switchTo().frame($("#Description_ifr"));
        $("#tinymce").setValue(description);
        Selenide.switchTo().defaultContent();
        return this;
    }
}
