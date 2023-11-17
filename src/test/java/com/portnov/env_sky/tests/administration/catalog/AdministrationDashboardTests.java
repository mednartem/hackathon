package com.portnov.env_sky.tests.administration.catalog;

import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.administration.AdministrationDashboardPage;
import com.portnov.env_sky.logic.pages.widgets.HeaderWidget;
import com.portnov.env_sky.logic.pages.BasePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

@Epic("Administration")
@Feature("Dashboard")
@WebTest
public class AdministrationDashboardTests {

    private final BasePage basePage = new BasePage();
    private final AdministrationDashboardPage administrationDashboardPage = new AdministrationDashboardPage();
    private final HeaderWidget headerWidget = new HeaderWidget();

    @Test
    void openAdminDashboardPage() {
        basePage
                .iOpenBasePage()
                .iAddCookieForAdminToBrowserAndRefreshPage();
        headerWidget
                .iClickAdministrationLink();
        administrationDashboardPage
                .pageShouldBeOpened();
    }
}
