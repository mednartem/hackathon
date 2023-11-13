package com.portnov.env_sky.logic.steps;

import com.codeborne.selenide.Selenide;
import com.portnov.env_sky.logic.rest.AuthorizationApi;
import io.qameta.allure.Step;
import com.portnov.env_sky.logic.dictionary.api.Cookie;

public class BaseSteps {

    @Step("I open base url")
    public BaseSteps iOpenBasePage() {
        Selenide.open("/");
        return this;
    }

    @Step("I add cookie to browser for user email `{email}`, password `{password}`")
    public void iAddCookieToBrowserAndRefreshPage(String email, String password) {
        String nopAuthToken = new AuthorizationApi().getNopAuthentication(email, password);
        Selenide.executeJavaScript(
                String.format("document.cookie = '%s = %s';", Cookie.NOP_AUTHENTICATION.getName(), nopAuthToken)
        );
        Selenide.refresh();
    }
}
