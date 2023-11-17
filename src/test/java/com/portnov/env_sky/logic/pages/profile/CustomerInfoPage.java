package com.portnov.env_sky.logic.pages.profile;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CustomerInfoPage {

    @Step("The `My Account` page should be opened`")
    public CustomerInfoPage pageShouldBeOpened() {
        $(".customer-info-page").shouldBe(visible);
        return this;
    }

    @Step("I type company name `{company}`")
    public CustomerInfoPage iTypeCompanyName(String company) {
        $("#Company").setValue(company);
        return this;
    }

    @Step("Company name should be: `{company}`")
    public CustomerInfoPage companyNameShouldBe(String company) {
        $("#Company").shouldHave(exactValue(company));
        return this;
    }

    @Step("I click Save button")
    public CustomerInfoPage iClickSaveBtn() {
        $("#save-info-button").click();
        return this;
    }
}
