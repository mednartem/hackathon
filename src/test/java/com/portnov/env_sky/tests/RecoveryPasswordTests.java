package com.portnov.env_sky.tests;

import com.portnov.env_sky.logic.config.ProjectConfig;
import com.portnov.env_sky.logic.data.RandomData;
import com.portnov.env_sky.logic.dictionary.ui.BarNotification;
import com.portnov.env_sky.logic.dictionary.ui.EndpointsUi;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.LogInPage;
import com.portnov.env_sky.logic.pages.PasswordRecoveryPage;
import com.portnov.env_sky.logic.pages.header.BarNotificationWidget;
import com.portnov.env_sky.logic.pages.header.HeaderWidget;
import com.portnov.env_sky.logic.pages.BasePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Test;

@Epic("Recovery password")
@WebTest
public class RecoveryPasswordTests {

    private final BasePage basePage = new BasePage();
    private final LogInPage logInPage = new LogInPage();
    private final PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();
    private final HeaderWidget headerWidget = new HeaderWidget();
    private final BarNotificationWidget barNotificationWidget = new BarNotificationWidget();

    @Test
    void recoveryPasswordValidForUser() {
        basePage
                .iOpenBasePage();
        headerWidget
                .iClickLoginLink();
        logInPage
                .iClickForgotPasswordLink();
        passwordRecoveryPage
                .iTypeEmail(ProjectConfig.credential.userEmail())
                .iClickRecoverBtn();
        barNotificationWidget
                .notificationShouldBeVisible(BarNotification.EMAIL_WITH_INSTRUCTIONS_HAS_BEEN_SENT_TO_YOU);
    }

    @Test
    @Link(value = "Test case TEAM1-74", url = "https://jira.portnov.com/browse/TEAM1-74")
    void recoveryPasswordValidForAdmin() {
        basePage
                .iOpenBasePage();
        headerWidget
                .iClickLoginLink();
        logInPage
                .iClickForgotPasswordLink();
        passwordRecoveryPage
                .iTypeEmail(ProjectConfig.credential.adminEmail())
                .iClickRecoverBtn();
        barNotificationWidget
                .notificationShouldBeVisible(BarNotification.EMAIL_WITH_INSTRUCTIONS_HAS_BEEN_SENT_TO_YOU);
    }

    @Test
    @Link(value = "Test case TEAM1-75", url = "https://jira.portnov.com/browse/TEAM1-75")
    void recoveryPasswordNotRegisterEmail() {
        basePage
                .iOpenBasePageWith(EndpointsUi.PASSWORD_RECOVERY);
        passwordRecoveryPage
                .iTypeEmail(RandomData.generateUniqEmail())
                .iClickRecoverBtn();
        barNotificationWidget
                .notificationShouldBeVisible(BarNotification.EMAIL_NOT_FOUND);
    }
}
