package com.portnov.env_sky.logic.pages.administration;

import com.portnov.env_sky.logic.dictionary.ui.administration.AdministrationMenu;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class AdministrationMenuWidget {

    @Step("I click menu {menu}")
    public AdministrationMenuWidget iClickMenu(AdministrationMenu menu) {
        $$("[role=menu] .nav-link").filter(visible).find(exactText(menu.getValue())).click();
        return this;
    }
}
