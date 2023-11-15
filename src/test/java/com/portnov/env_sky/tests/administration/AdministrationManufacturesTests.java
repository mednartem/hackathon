package com.portnov.env_sky.tests.administration;

import com.portnov.env_sky.logic.db.dao.impl.ManufacturerDAOJdbc;
import com.portnov.env_sky.logic.dictionary.ui.administration.*;
import com.portnov.env_sky.logic.data.RandomData;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.administration.manufacturer.AdministrationManufacturerCreatePage;
import com.portnov.env_sky.logic.pages.administration.manufacturer.AdministrationManufacturersPage;
import com.portnov.env_sky.logic.pages.administration.widgets.*;
import com.portnov.env_sky.logic.steps.BaseSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Epic("Administration")
@Feature("Catalog")
@Story("Manufacturer")
@WebTest
public class AdministrationManufacturesTests {

    private final BaseSteps baseSteps = new BaseSteps();
    private final AdministrationManufacturersPage manufacturersPage = new AdministrationManufacturersPage();
    private final AdministrationManufacturerCreatePage manufacturerCreatePage = new AdministrationManufacturerCreatePage();
    private final AdministrationMenuWidget menuWidget = new AdministrationMenuWidget();
    private final AdministrationHeaderWidget headerWidget = new AdministrationHeaderWidget();
    private final AdministrationModalWidget modalWidget = new AdministrationModalWidget();
    private final AdministrationAlertNotificationWidget alertNotificationWidget = new AdministrationAlertNotificationWidget();
    private final AdministrationDataTableLengthWidget dataTableLengthWidget = new AdministrationDataTableLengthWidget();
    private final ManufacturerDAOJdbc manufacturerDAOJdbc = new ManufacturerDAOJdbc();

    @Test
    void openManufacturersPage() {
        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.DASHBOARD);
        menuWidget
                .iClickMenu(AdministrationMenu.CATALOG)
                .iClickMenu(AdministrationMenu.MANUFACTURERS);
        manufacturersPage
                .pageShouldBeOpened();
    }

    @Test
    @Link(value = "Test case TEAM1-47", url = "https://jira.portnov.com/browse/TEAM1-47")
    void addNewManufacturerBasic() {
        String name = RandomData.generateNameManufacturer();
        String description = RandomData.generateDescriptionManufacturer();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_MANUFACTURER);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.ADD_NEW);
        manufacturerCreatePage
                .iTypeName(name)
                .iTypeDescription(description);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_MANUFACTURER_HAS_BEEN_ADDED_SUCCESSFULLY);
        manufacturersPage
                .pageShouldBeOpened();
        manufacturersPage
                .manufacturerShouldBeDisplayInTheTable(name);
    }

    @Test
    @Link(value = "Test case TEAM1-54", url = "https://jira.portnov.com/browse/TEAM1-54")
    void deleteManufacturerFromEditForm() {
        String name = manufacturerDAOJdbc.create().getName();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_MANUFACTURER);
        manufacturersPage
                .clickEditBtnAtTheManufacturer(name);
        manufacturerCreatePage
                .pageShouldBeOpened();
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE);
        modalWidget
                .iClickBtn(AdministrationModalButton.DELETE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_MANUFACTURER_HAS_BEEN_DELETED_SUCCESSFULLY);
        manufacturersPage
                .manufacturerShouldNotBeDisplayInTheTable(name);
    }

    @Test
    @Link(value = "Test case TEAM1-55", url = "https://jira.portnov.com/browse/TEAM1-55")
    void deleteManufacturerFromManufacturersPage() {
        String name = manufacturerDAOJdbc.create().getName();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_MANUFACTURER);
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        manufacturersPage
                .selectCheckboxAtTheManufacturer(name);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE_SELECTED);
        modalWidget
                .iClickBtn(AdministrationModalButton.YES);
        manufacturersPage
                .manufacturerShouldNotBeDisplayInTheTable(name);
    }
}
