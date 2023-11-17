package com.portnov.env_sky.logic.pages.widgets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HeaderWidget {

    private final SelenideElement
            elLoginLink = $(".ico-login"),
            elRegisterLink = $(".ico-register"),
            elLogoutLink = $(".ico-logout"),
            elMyAccountLink = $(".ico-account"),
            elAdministrationLink = $(".administration"),
            elShoppingCart = $("#topcartlink");

    @Step("`Log in` link should be visible in the header")
    public void loginBtnShouldBeVisible() {
        elLoginLink.shouldBe(visible);
    }

    @Step("I click `Log in` link in the header")
    public void iClickLoginLink() {
        elLoginLink.click();
    }

    @Step("I click `Register` link in the header")
    public void iClickRegisterLink() {
        elRegisterLink.click();
    }

    @Step("I click `Log out` link in the header")
    public HeaderWidget iClickLogoutLink() {
        elLogoutLink.click();
        return this;
    }

    @Step("`Log out` link should be visible in the header")
    public HeaderWidget logoutLinkShouldBeVisible() {
        elLogoutLink.shouldBe(visible);
        return this;
    }

    @Step("`My account` link should be visible in the header")
    public HeaderWidget myAccountLinkShouldBeVisible() {
        elMyAccountLink.shouldBe(visible);
        return this;
    }

    @Step("`Administration` link should be visible in the header")
    public void administrationLinkShouldBeVisible() {
        elAdministrationLink.shouldBe(visible);
    }

    @Step("`Administration` link should not be visible in the header")
    public void administrationLinkShouldNotBeVisible() {
        elAdministrationLink.shouldNotBe(visible);
    }

    @Step("I click `Administration` link in the header")
    public void iClickAdministrationLink() {
        elAdministrationLink.click();
    }

    @Step("I click to `Shopping cart` link in the header")
    public void iClickShoppingCartLink() {
        elShoppingCart.click();
    }
}
