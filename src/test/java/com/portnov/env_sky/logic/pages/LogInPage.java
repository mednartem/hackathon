package com.portnov.env_sky.logic.pages;

import com.portnov.env_sky.logic.dictionary.ui.Error;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class LogInPage {
    @Step("I type email `{email}`")
    public LogInPage iTypeEmail(String email) {
        $("#Email").setValue(email);
        return this;
    }

    @Step("I type password `{password}`")
    public LogInPage iTypePassword(String password) {
        $("#Password").setValue(password);
        return this;
    }

    @Step("I click `Log in` button")
    public LogInPage iClickLoginBtn() {
        $(".login-button").click();
        return this;
    }

    @Step("I click `Forgot password?` link")
    public LogInPage iClickForgotPasswordLink() {
        $(".forgot-password").click();
        return this;
    }

    @Step("Message error should be {error}")
    public void messageErrorShouldBe(Error error) {
        $(".message-error").shouldHave(exactText(error.getValue()));
    }

    @Step("The email field should have the error `{error}`")
    public void emailFieldShouldHaveError(Error error) {
        $("#Email-error").shouldHave(exactText(error.getValue()));
    }
}
