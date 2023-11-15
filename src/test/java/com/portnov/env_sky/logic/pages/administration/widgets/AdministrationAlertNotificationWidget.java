package com.portnov.env_sky.logic.pages.administration.widgets;

import com.portnov.env_sky.logic.dictionary.ui.administration.AdministrationAlertNotification;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AdministrationAlertNotificationWidget {

    @Step("The alert notification `{alert}` should be visible on the top of the page")
    public void alertNotificationShouldBeVisible(AdministrationAlertNotification alert) {
        $(".alert").shouldHave(text(alert.getValue()));
    }
}
