package com.portnov.env_sky.logic.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class PasswordRecoveryPage {

    @Step("I type email `{email}`")
    public PasswordRecoveryPage iTypeEmail(String email) {
        $("[action='/passwordrecovery'] #Email").setValue(email);
        return this;
    }

    @Step("I click `Recover` button")
    public void iClickRecoverBtn() {
        $(".password-recovery-button").click();
    }
}
