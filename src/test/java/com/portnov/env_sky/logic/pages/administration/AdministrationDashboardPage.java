package com.portnov.env_sky.logic.pages.administration;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdministrationDashboardPage {

    @Step("`Dashboard` page should be opened`")
    public void pageShouldBeOpened() {
        $("#configuration-steps-card").shouldBe(visible);
    }
}
