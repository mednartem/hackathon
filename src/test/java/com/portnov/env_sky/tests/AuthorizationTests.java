package com.portnov.env_sky.tests;

import com.portnov.env_sky.logic.config.ProjectConfig;
import com.portnov.env_sky.logic.dictionary.ui.EndpointsUi;
import com.portnov.env_sky.logic.dictionary.ui.Error;
import com.portnov.env_sky.logic.helpers.RandomData;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.widgets.HeaderWidget;
import com.portnov.env_sky.logic.pages.LogInPage;
import com.portnov.env_sky.logic.steps.BaseSteps;
import io.qameta.allure.Link;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@WebTest
public class AuthorizationTests {

    private final BaseSteps baseSteps = new BaseSteps();
    private final LogInPage logInPage = new LogInPage();
    private final HeaderWidget headerWidget = new HeaderWidget();

    @Test
    @Link(value = "Test case TEAM1-58", url = "https://jira.portnov.com/browse/TEAM1-58")
    void loginValidAsAdmin() {
        baseSteps
                .iOpenBasePage();
        headerWidget
                .iClickLoginLink();
        logInPage
                .iTypeEmail(ProjectConfig.credential.adminEmail())
                .iTypePassword(ProjectConfig.credential.adminPassword())
                .iClickLoginBtn();
        headerWidget
                .logoutLinkShouldBeVisible()
                .myAccountLinkShouldBeVisible()
                .administrationLinkShouldBeVisible();
    }

    @Test
    void loginValidAsUser() {
        baseSteps
                .iOpenBasePageWith(EndpointsUi.LOGIN);
        logInPage
                .iTypeEmail(ProjectConfig.credential.userEmail())
                .iTypePassword(ProjectConfig.credential.userPassword())
                .iClickLoginBtn();
        headerWidget
                .logoutLinkShouldBeVisible()
                .myAccountLinkShouldBeVisible()
                .administrationLinkShouldNotBeVisible();
    }

    @DisplayName("Invalid login")
    @ParameterizedTest(name = "{index} {3} => email=''{0}'', password=''{1}'', errorShouldBe={2}")
    @Link(value = "Test case TEAM1-59", url = "https://jira.portnov.com/browse/TEAM1-59")
    @Link(value = "Test case TEAM1-62", url = "https://jira.portnov.com/browse/TEAM1-62")
    @Link(value = "Test case TEAM1-65", url = "https://jira.portnov.com/browse/TEAM1-65")
    @MethodSource("invalidData")
    void loginInvalid(String email, String password, Error error, String displayName) {
        baseSteps
                .iOpenBasePageWith(EndpointsUi.LOGIN);
        logInPage
                .iTypeEmail(email)
                .iTypePassword(password)
                .iClickLoginBtn()
                .messageErrorShouldBe(error);
    }

    private static Stream<Arguments> invalidData() {
        return Stream.of(
                Arguments.of(
                        ProjectConfig.credential.adminEmail(),
                        RandomData.generatePassword(),
                        Error.LOGIN_UNSUCCESSFUL_INCORRECT_CREDENTIALS,
                        "Wrong `Password`"
                ),
                Arguments.of(
                        ProjectConfig.credential.adminEmail(),
                        "",
                        Error.LOGIN_UNSUCCESSFUL_INCORRECT_CREDENTIALS,
                        "Empty `Password`"
                ),
                Arguments.of(
                        RandomData.generateUniqEmail(),
                        ProjectConfig.credential.adminPassword(),
                        Error.LOGIN_UNSUCCESSFUL_NO_CUSTOMER_ACCOUNT_FOUND,
                        "Wrong `Email`"
                ),
                Arguments.of(
                        RandomData.generateUniqEmail(),
                        RandomData.generatePassword(),
                        Error.LOGIN_UNSUCCESSFUL_NO_CUSTOMER_ACCOUNT_FOUND,
                        "Wrong `Email` and `Password`"
                )
        );
    }

    @ParameterizedTest(name = "{index} {3} => email=''{0}'', password=''{1}'', errorShouldBe={2}")
    @MethodSource("combineEmptyEmailField")
    void loginWithEmptyFields(String email, String password, Error error, String displayName) {
        baseSteps
                .iOpenBasePageWith(EndpointsUi.LOGIN);
        logInPage
                .iTypeEmail(email)
                .iTypePassword(password)
                .iClickLoginBtn()
                .emailFieldShouldHaveError(error);
    }

    private static Stream<Arguments> combineEmptyEmailField() {
        return Stream.of(
                Arguments.of(
                        "",
                        RandomData.generatePassword(),
                        Error.PLEASE_ENTER_YOUR_EMAIL,
                        "Empty `Email` field"
                ),
                Arguments.of(
                        "",
                        "",
                        Error.PLEASE_ENTER_YOUR_EMAIL,
                        "Empty `Email` and `Password` field"
                )
        );
    }

    @Test
    void logoutAdmin() {
        baseSteps
                .iOpenBasePage()
                .iAddCookieToBrowserAndRefreshPage(ProjectConfig.credential.adminEmail(), ProjectConfig.credential.adminPassword());
        headerWidget
                .iClickLogoutLink()
                .loginBtnShouldBeVisible();
    }

    @Test
    void logoutUser() {
        baseSteps
                .iOpenBasePage()
                .iAddCookieToBrowserAndRefreshPage(ProjectConfig.credential.userEmail(), ProjectConfig.credential.userPassword());
        headerWidget
                .iClickLogoutLink()
                .loginBtnShouldBeVisible();
    }
}
