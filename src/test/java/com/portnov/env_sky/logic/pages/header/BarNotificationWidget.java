package com.portnov.env_sky.logic.pages.header;

import com.portnov.env_sky.logic.dictionary.ui.BarNotification;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class BarNotificationWidget {

    @Step("The notification `{barNotification}` should be visible on the top of the page")
    public void notificationShouldBeVisible(BarNotification barNotification) {
        $(".bar-notification").shouldHave(exactText(barNotification.getValue()));
    }
}
