package com.portnov.env_sky.logic.pages.header;

import com.codeborne.selenide.ElementsCollection;
import com.portnov.env_sky.logic.dictionary.ui.MenuHeader;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderMenuWidget {

    private final ElementsCollection
            elListMenu = $$(".top-menu li"),
            elListSubMenu = $$(".top-menu ul li");

    @Step("I click menu `{menu}` in the header")
    public void iClickMenuInTheHeader(MenuHeader menu) {
        elListMenu.filter(visible).find(exactText(menu.getValue())).click();
    }

    @Step("I hover menu `{menu}` in the header")
    public HeaderMenuWidget iHoverMenuInTheHeader(MenuHeader menu) {
        elListMenu.filter(visible).find(exactText(menu.getValue())).hover();
        return this;
    }

    @Step("I click sub menu `{menu}` in the header")
    public void iClickSubMenuInTheHeader(MenuHeader menu) {
        elListSubMenu.filter(visible).find(exactText(menu.getValue())).click();
    }


}
