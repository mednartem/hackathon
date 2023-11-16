package com.portnov.env_sky.logic.pages.administration.customer;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdministrationCustomerCreatePage {

    @Step("`Create Customer` page should be opened`")
    public void pageShouldBeOpened() {
        $("#manufacturer-cards").shouldBe(visible);
    }

    @Step("I type email `{email}`")
    public AdministrationCustomerCreatePage iTypeEmail(String email) {
        $("#Email").setValue(email);
        return this;
    }

    @Step("I type password `{password}`")
    public AdministrationCustomerCreatePage iTypePassword(String password) {
        $("#Password").setValue(password);
        return this;
    }

    @Step("I type first name `{name}`")
    public AdministrationCustomerCreatePage iTypeFirstName(String name) {
        $("#FirstName").setValue(name);
        return this;
    }

    @Step("I type last name `{name}`")
    public AdministrationCustomerCreatePage iTypeLastName(String name) {
        $("#LastName").setValue(name);
        return this;
    }

    @Step("I type company name `{name}`")
    public AdministrationCustomerCreatePage iTypeCompanyName(String name) {
        $("#Company").setValue(name);
        return this;
    }

    @Step("I select the `Male` gender")
    public AdministrationCustomerCreatePage iSelectMaleGender() {
        $("#Gender_Male").click();
        return this;
    }
}
