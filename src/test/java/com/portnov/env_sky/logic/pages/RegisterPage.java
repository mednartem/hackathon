package com.portnov.env_sky.logic.pages;

import com.portnov.env_sky.logic.dictionary.ui.Error;
import com.portnov.env_sky.logic.dictionary.ui.Message;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {

    @Step("I select the `Male` gender")
    public RegisterPage iSelectMaleGender() {
        $("#gender-male").click();
        return this;
    }

    @Step("I select the `Female` gender")
    public RegisterPage iSelectFemaleGender() {
        $("#gender-female").click();
        return this;
    }

    @Step("I type firstName `{firstName}`")
    public RegisterPage iTypeFirstName(String firstName) {
        $("#FirstName").setValue(firstName);
        return this;
    }

    @Step("I type lastName `{lastName}`")
    public RegisterPage iTypeLastName(String lastName) {
        $("#LastName").setValue(lastName);
        return this;
    }

    @Step("I select `Date of birth`: {month} {day} {year}")
    public RegisterPage iSelectDateOfBirth(String day, String month, String year) {
        $("[name=DateOfBirthDay]").selectOption(day);
        $("[name=DateOfBirthMonth]").selectOption(month);
        $("[name=DateOfBirthYear]").selectOption(year);
        return this;
    }

    @Step("I type email `{email}`")
    public RegisterPage iTypeEmail(String email) {
        $("#Email").setValue(email);
        return this;
    }

    @Step("I type password `{password}`")
    public RegisterPage iTypePassword(String password) {
        $("#Password").setValue(password);
        return this;
    }

    @Step("I type confirmPassword `{confirmPassword}`")
    public RegisterPage iTypeConfirmPassword(String confirmPassword) {
        $("#ConfirmPassword").setValue(confirmPassword);
        return this;
    }

    @Step("I click `Register` button")
    public RegisterPage iClickRegisterBtn() {
        $("#register-button").click();
        return this;
    }

    @Step("I click `Continue` button")
    public RegisterPage iClickContinueBtn() {
        $(".register-continue-button").click();
        return this;
    }

    @Step("Message {message} should be visible")
    public void messageShouldBeVisible(Message message) {
        $(".result").shouldHave(exactText(message.getValue()));
    }

    @Step("The first name field should have the error `{error}`")
    public RegisterPage firstNameFieldShouldHaveError(Error error) {
        $("#FirstName-error").shouldHave(exactText(error.getValue()));
        return this;
    }

    @Step("The last name field should have the error `{error}`")
    public RegisterPage lastNameFieldShouldHaveError(Error error) {
        $("#LastName-error").shouldHave(exactText(error.getValue()));
        return this;
    }

    @Step("The email field should have the error `{error}`")
    public RegisterPage emailFieldShouldHaveError(Error error) {
        $("#Email-error").shouldHave(exactText(error.getValue()));
        return this;
    }

    @Step("The password field should have the error `{error}`")
    public RegisterPage passwordFieldShouldHaveError(Error error) {
        $("#Password-error").shouldHave(exactText(error.getValue()));
        return this;
    }

    @Step("The confirm password field should have the error `{error}`")
    public RegisterPage confirmPasswordFieldShouldHaveError(Error error) {
        $("#ConfirmPassword-error").shouldHave(exactText(error.getValue()));
        return this;
    }
}
