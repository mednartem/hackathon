package com.portnov.env_sky.tests;

import com.portnov.env_sky.logic.config.ProjectConfig;
import com.portnov.env_sky.logic.dictionary.ui.Error;
import com.portnov.env_sky.logic.helpers.RandomData;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.steps.AuthSteps;
import com.portnov.env_sky.logic.steps.BaseSteps;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@WebTest
public class AuthorizationTests {

    private final BaseSteps baseSteps = new BaseSteps();
    private final AuthSteps authSteps = new AuthSteps();

    @Test
    @Link("https://jira.portnov.com/browse/TEAM1-58")
    void test01LoginValid() {
        baseSteps
                .iOpenBasePage();
        authSteps
                .iClickLoginBtnInTheHeader()
                .iTypeEmail(ProjectConfig.credential.adminEmail())
                .iTypePassword(ProjectConfig.credential.adminPassword())
                .iClickLoginBtn()
                .accountLinkShouldBeVisibleInTheHeader();
    }

    private static Stream<Arguments> invalidData() {
        return Stream.of(
                Arguments.of(ProjectConfig.credential.adminEmail(), RandomData.generatePassword(), Error.LOGIN_UNSUCCESSFUL_INCORRECT_CREDENTIALS),
                Arguments.of(ProjectConfig.credential.adminEmail(), "", Error.LOGIN_UNSUCCESSFUL_INCORRECT_CREDENTIALS),
                Arguments.of(RandomData.generateUniqEmail(), ProjectConfig.credential.adminPassword(), Error.LOGIN_UNSUCCESSFUL_NO_CUSTOMER_ACCOUNT_FOUND),
                Arguments.of(RandomData.generateUniqEmail(), RandomData.generatePassword(), Error.LOGIN_UNSUCCESSFUL_NO_CUSTOMER_ACCOUNT_FOUND)
        );
    }

    @ParameterizedTest
    @Link("https://jira.portnov.com/browse/TEAM1-59")
    @Link("https://jira.portnov.com/browse/TEAM1-62")
    @Link("https://jira.portnov.com/browse/TEAM1-65")
    @MethodSource("invalidData")
    void test02LoginInvalid(String email, String password, Error error) {
        baseSteps
                .iOpenBasePage();
        authSteps
                .iClickLoginBtnInTheHeader()
                .iTypeEmail(email)
                .iTypePassword(password)
                .iClickLoginBtn()
                .messageErrorShouldBe(error);
    }

    private static Stream<Arguments> combineEmptyEmailField() {
        return Stream.of(
                Arguments.of("", RandomData.generatePassword(), Error.PLEASE_ENTER_YOUR_EMAIL),
                Arguments.of("", "", Error.PLEASE_ENTER_YOUR_EMAIL)
        );
    }

    @ParameterizedTest
    @MethodSource("combineEmptyEmailField")
    void test03LoginWithEmptyFields(String email, String password, Error error) {
        baseSteps
                .iOpenBasePage();
        authSteps
                .iClickLoginBtnInTheHeader()
                .iTypeEmail(email)
                .iTypePassword(password)
                .iClickLoginBtn()
                .emailFieldShouldHaveError(error);
    }

    @Test
    void test04Logout() {
        baseSteps
                .iOpenBasePage()
                .iAddCookieToBrowserAndRefreshPage(ProjectConfig.credential.adminEmail(), ProjectConfig.credential.adminPassword());
        authSteps
                .iClickLogoutBtnInTheHeader()
                .loginBtnShouldBeVisibleInTheHeader();
    }
}
