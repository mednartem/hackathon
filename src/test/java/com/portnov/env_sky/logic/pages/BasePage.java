package com.portnov.env_sky.logic.pages;

import com.codeborne.selenide.Selenide;
import com.portnov.env_sky.logic.config.ProjectConfig;
import com.portnov.env_sky.logic.dictionary.api.Cookie;
import com.portnov.env_sky.logic.rest.AuthorizationApi;
import com.portnov.env_sky.logic.rest.model.PersonModel;
import io.qameta.allure.Step;

public class BasePage {

    @Step("I open base url")
    public BasePage iOpenBasePage() {
        Selenide.open("/");
        return this;
    }

    @Step("I open base url with {url}")
    public BasePage iOpenBasePageWith(String url) {
        Selenide.open(url);
        return this;
    }

    @Step("I open base url with {url} with admin`s cookie")
    public BasePage iOpenBasePageWithAdminCookie(String url) {
        iOpenBasePage();
        iAddCookieForAdminToBrowserAndRefreshPage();
        iOpenBasePageWith(url);
        return this;
    }

    @Step("I open base url with admin`s cookie")
    public BasePage iOpenBasePageWithAdminCookie() {
        iOpenBasePage();
        iAddCookieForAdminToBrowserAndRefreshPage();
        return this;
    }

    @Step("I open base url with user`s cookie")
    public BasePage iOpenBasePageWithUserCookie() {
        iOpenBasePage();
        iAddCookieForUserToBrowserAndRefreshPage();
        return this;
    }

    @Step("I add cookie to browser for user email `{email}`, password `{password}`")
    public void iAddCookieToBrowserAndRefreshPage(String email, String password) {
        PersonModel personModel = new AuthorizationApi().getNopAuthentication(email, password);
        Selenide.executeJavaScript(
                String.format("document.cookie = '%s = %s';", Cookie.NOP_AUTHENTICATION.getName(), personModel.getCookieNopAuthentication())
        );
        Selenide.refresh();
    }

    @Step("I add cookie to browser for admin")
    public BasePage iAddCookieForAdminToBrowserAndRefreshPage() {
        iAddCookieToBrowserAndRefreshPage(
                ProjectConfig.credential.adminEmail(),
                ProjectConfig.credential.adminPassword()
        );
        return this;
    }

    @Step("I add cookie to browser for user")
    public BasePage iAddCookieForUserToBrowserAndRefreshPage() {
        iAddCookieToBrowserAndRefreshPage(
                ProjectConfig.credential.userEmail(),
                ProjectConfig.credential.userPassword()
        );
        return this;
    }
}
