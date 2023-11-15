package com.portnov.env_sky.logic.pages.administration.widgets;

import com.portnov.env_sky.logic.dictionary.ui.administration.AdministrationModalButton;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AdministrationModalWidget {

    @Step("I click `{button}` button in the modal dialog")
    public void iClickBtn(AdministrationModalButton button) {
        $x(String.format("//*[@class='modal-content']//*[text()='%s']", button.getValue())).click();
    }
}
