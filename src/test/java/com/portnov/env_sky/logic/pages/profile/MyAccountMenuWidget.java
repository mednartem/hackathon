package com.portnov.env_sky.logic.pages.profile;

import com.portnov.env_sky.logic.dictionary.ui.MyAccountMenu;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class MyAccountMenuWidget {

    @Step("I click menu `{menu}` in the `My Account` block")
    public void iClickMenu(MyAccountMenu menu) {
        $$(".block-account-navigation a").filter(visible).find(exactText(menu.getValue())).click();
    }
}
