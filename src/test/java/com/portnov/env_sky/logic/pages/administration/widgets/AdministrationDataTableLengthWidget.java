package com.portnov.env_sky.logic.pages.administration.widgets;

import com.portnov.env_sky.logic.dictionary.ui.administration.AdministrationDataTableLength;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AdministrationDataTableLengthWidget {

    @Step("I select length {length}")
    public void iSelectLength(AdministrationDataTableLength length) {
        $("[name*=grid_length]").selectOption(length.getValue());
    }
}
