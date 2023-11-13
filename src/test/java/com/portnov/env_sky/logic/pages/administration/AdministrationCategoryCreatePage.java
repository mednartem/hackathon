package com.portnov.env_sky.logic.pages.administration;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdministrationCategoryCreatePage {

    @Step("`Categories` page should be opened`")
    public AdministrationCategoryCreatePage pageShouldBeOpened() {
        $("#category-cards").shouldBe(visible);
        return this;
    }

    @Step("I switch from `Basic` to `Advanced`")
    public AdministrationCategoryCreatePage iSwitchBasicToAdvanced() {
        //todo It works not stable without if block. Need to understand this behavior and remove the if block
        if (!$(".uploaded-image").isDisplayed()) {
            $("[for='advanced-settings-mode']").click();
        }
        $(".uploaded-image").shouldBe(visible);
        return this;
    }

    @Step("I type name `{name}`")
    public AdministrationCategoryCreatePage iTypeName(String name) {
        $("#Name").setValue(name);
        return this;
    }

    @Step("I type name `{name}`")
    public AdministrationCategoryCreatePage iTypeDescription(String description) {
        Selenide.switchTo().frame($("#Description_ifr"));
        $("#tinymce").setValue(description);
        Selenide.switchTo().defaultContent();
        return this;
    }

    @Step("I select parent category `{name}`")
    public AdministrationCategoryCreatePage iSelectParentCategory(String name) {
        $("#ParentCategoryId").selectOption(name);
        return this;
    }

    @Step("I upload picture")
    public void iUploadPicture() {
        $("[name=qqfile]").uploadFromClasspath("hackathon.jpg");
        $(".remove-image-button").shouldBe(visible);
    }
}
