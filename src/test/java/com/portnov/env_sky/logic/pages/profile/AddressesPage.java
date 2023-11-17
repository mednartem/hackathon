package com.portnov.env_sky.logic.pages.profile;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AddressesPage {

    @Step("The `My Account - Addresses` page should be opened`")
    public AddressesPage pageShouldBeOpened() {
        $(".address-list-page").shouldBe(visible);
        return this;
    }

    @Step("Name should be: `{name}`")
    public AddressesPage nameShouldBe(String name) {
        $(".address-item .name").shouldHave(text(name));
        return this;
    }

    @Step("Email should be: `{email}`")
    public AddressesPage emailShouldBe(String email) {
        $(".address-item .email").shouldHave(text(email));
        return this;
    }

    @Step("Phone should be: `{phone}`")
    public AddressesPage phoneShouldBe(String phone) {
        $(".address-item .phone").shouldHave(text(phone));
        return this;
    }

    @Step("Fax should be: `{fax}`")
    public AddressesPage faxShouldBe(String fax) {
        $(".address-item .fax").shouldHave(text(fax));
        return this;
    }

    @Step("Address 1 should be: `{address}`")
    public AddressesPage address1ShouldBe(String address) {
        $(".address-item .address1").shouldHave(text(address));
        return this;
    }

    @Step("City, state, zip should be: `{city}, {state}, {zip}`")
    public AddressesPage cityStateZipShouldBe(String city, String state, String zip) {
        $(".address-item .city-state-zip").shouldHave(text(String.format("%s, %s, %s", city, state, zip)));
        return this;
    }

    @Step("Country should be: `{country}`")
    public AddressesPage countryShouldBe(String country) {
        $(".address-item .country").shouldHave(text(country));
        return this;
    }
}
