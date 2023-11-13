package com.portnov.env_sky.logic.pages.administration;

import com.portnov.env_sky.logic.dictionary.ui.administration.AdministrationHeaderButton;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class AdministrationHeaderWidget {

    @Step("I click `{button}` link in the header")
    public void iClickBtn(AdministrationHeaderButton button) {
        $$(".float-right .btn").filter(visible).find(exactText(button.getValue())).click();
    }
}
