package com.portnov.env_sky.tests.administration;

import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.administration.AdministrationDashboardPage;
import com.portnov.env_sky.logic.pages.widgets.HeaderWidget;
import com.portnov.env_sky.logic.steps.BaseSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

@Epic("Administration")
@Feature("Dashboard")
@WebTest
public class AdministrationDashboardTests {

    private final BaseSteps baseSteps = new BaseSteps();
    private final AdministrationDashboardPage administrationDashboardPage = new AdministrationDashboardPage();
    private final HeaderWidget headerWidget = new HeaderWidget();

    @Test
    void openAdminDashboardPage() {
        baseSteps
                .iOpenBasePage()
                .iAddCookieForAdminToBrowserAndRefreshPage();
        headerWidget
                .iClickAdministrationLink();
        administrationDashboardPage
                .pageShouldBeOpened();
    }
}
