package com.portnov.env_sky.tests;

import com.portnov.env_sky.logic.config.ProjectConfig;
import com.portnov.env_sky.logic.dictionary.ui.BarNotification;
import com.portnov.env_sky.logic.dictionary.ui.EndpointsUi;
import com.portnov.env_sky.logic.helpers.RandomData;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.BarNotificationWidget;
import com.portnov.env_sky.logic.pages.HeaderWidget;
import com.portnov.env_sky.logic.pages.LogInPage;
import com.portnov.env_sky.logic.pages.PasswordRecoveryPage;
import com.portnov.env_sky.logic.steps.BaseSteps;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Test;

@WebTest
public class RecoveryPasswordTests {

    private final BaseSteps baseSteps = new BaseSteps();
    private final LogInPage logInPage = new LogInPage();
    private final PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();
    private final HeaderWidget headerWidget = new HeaderWidget();
    private final BarNotificationWidget barNotificationWidget = new BarNotificationWidget();

    @Test
    @Link(value = "Test case TEAM1-74", url = "https://jira.portnov.com/browse/TEAM1-74")
    void recoverPasswordValid() {
        baseSteps
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
    void recoverPasswordNotRegisterEmail() {
        baseSteps
                .iOpenBasePageWith(EndpointsUi.PASSWORD_RECOVERY);
        passwordRecoveryPage
                .iTypeEmail(RandomData.generateUniqEmail())
                .iClickRecoverBtn();
        barNotificationWidget
                .notificationShouldBeVisible(BarNotification.EMAIL_NOT_FOUND);
    }
}
