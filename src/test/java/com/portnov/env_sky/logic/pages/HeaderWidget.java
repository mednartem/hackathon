package com.portnov.env_sky.logic.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HeaderWidget {

    @Step("`Log in` link should be visible in the header")
    public void loginBtnShouldBeVisible() {
        $(".ico-login").shouldBe(visible);
    }

    @Step("I click `Log in` link in the header")
    public HeaderWidget iClickLoginLink() {
        $(".ico-login").click();
        return this;
    }

    @Step("I click `Register` link in the header")
    public void iClickRegisterLink() {
        $(".ico-register").click();
    }

    @Step("I click `Log out` link in the header")
    public HeaderWidget iClickLogoutLink() {
        $(".ico-logout").click();
        return this;
    }

    @Step("`Log out` link should be visible in the header")
    public HeaderWidget logoutLinkShouldBeVisible() {
        $(".ico-logout").shouldBe(visible);
        return this;
    }

    @Step("`My account` link should be visible in the header")
    public void myAccountLinkShouldBeVisible() {
        $(".ico-account").shouldBe(visible);
    }
}
