package com.portnov.env_sky.tests;

import com.portnov.env_sky.logic.data.RandomData;
import com.portnov.env_sky.logic.dictionary.ui.EndpointsUi;
import com.portnov.env_sky.logic.dictionary.ui.Error;
import com.portnov.env_sky.logic.dictionary.ui.Message;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.RegisterPage;
import com.portnov.env_sky.logic.pages.header.HeaderWidget;
import com.portnov.env_sky.logic.pages.BasePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Test;

@Epic("Registration")
@WebTest
public class RegistrationTests {

    private final BasePage basePage = new BasePage();
    private final RegisterPage registerPage = new RegisterPage();
    private final HeaderWidget headerWidget = new HeaderWidget();

    @Test
    @Link(value = "Test case TEAM1-53", url = "https://jira.portnov.com/browse/TEAM1-53")
    void registerValid() {
        String firstName = RandomData.generateString(6);
        String lastName = RandomData.generateString(6);
        String email = RandomData.generateUniqEmail();
        String password = RandomData.generatePassword();

        basePage
                .iOpenBasePage();
        headerWidget
                .iClickRegisterLink();
        registerPage
                .iTypeFirstName(firstName)
                .iTypeLastName(lastName)
                .iTypeEmail(email)
                .iTypePassword(password)
                .iTypeConfirmPassword(password)
                .iClickRegisterBtn()
                .messageShouldBeVisible(Message.YOUR_REGISTRATION_COMPLETED);
        headerWidget
                .logoutLinkShouldBeVisible()
                .myAccountLinkShouldBeVisible();

        //todo add connect with DB, then uncomment the step below and check in BD
//        registerPage
//                .iClickContinueBtn();
    }

    @Test
    @Link(value = "Test case TEAM1-70", url = "https://jira.portnov.com/browse/TEAM1-70")
    void registerPasswordLessThanSixCharacters() {
        String firstName = RandomData.generateString(6);
        String lastName = RandomData.generateString(6);
        String email = RandomData.generateUniqEmail();
        String password = RandomData.generateString(5);

        basePage
                .iOpenBasePageWith(EndpointsUi.REGISTER);
        registerPage
                .iTypeFirstName(firstName)
                .iTypeLastName(lastName)
                .iTypeEmail(email)
                .iTypePassword(password)
                .iClickRegisterBtn()
                .passwordFieldShouldHaveError(Error.MUST_HAVE_AT_LEAST_SIX_CHARACTERS);
    }

    @Test
    @Link(value = "Test case TEAM1-72", url = "https://jira.portnov.com/browse/TEAM1-72")
    void registerWithEmptyRequiredFields() {
        basePage
                .iOpenBasePageWith(EndpointsUi.REGISTER);
        registerPage
                .iClickRegisterBtn()
                .firstNameFieldShouldHaveError(Error.FIRST_NAME_IS_REQUIRED)
                .lastNameFieldShouldHaveError(Error.LAST_NAME_IS_REQUIRED)
                .emailFieldShouldHaveError(Error.EMAIL_IS_REQUIRED)
                .passwordFieldShouldHaveError(Error.PASSWORD_IS_REQUIRED)
                .confirmPasswordFieldShouldHaveError(Error.PASSWORD_IS_REQUIRED);
    }

    @Test
    @Link(value = "Test case TEAM1-73", url = "https://jira.portnov.com/browse/TEAM1-73")
    void registerWithInappropriateFormatOfEmail() {
        String firstName = RandomData.generateString(6);
        String lastName = RandomData.generateString(6);
        String email = RandomData.generateString(5);
        String password = RandomData.generatePassword();

        basePage
                .iOpenBasePageWith(EndpointsUi.REGISTER);
        registerPage
                .iTypeFirstName(firstName)
                .iTypeLastName(lastName)
                .iTypeEmail(email)
                .iTypePassword(password)
                .iClickRegisterBtn()
                .emailFieldShouldHaveError(Error.WRONG_EMAIL);
    }
}
