package com.portnov.env_sky.tests.administration.catalog;

import com.portnov.env_sky.logic.data.FillManufacturerEntity;
import com.portnov.env_sky.logic.data.RandomData;
import com.portnov.env_sky.logic.db.dao.ManufacturerDAO;
import com.portnov.env_sky.logic.db.model.ManufacturerEntity;
import com.portnov.env_sky.logic.dictionary.ui.administration.*;
import com.portnov.env_sky.logic.jupiter.Dao;
import com.portnov.env_sky.logic.jupiter.DaoExtension;
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
import org.junit.jupiter.api.extension.ExtendWith;

@Epic("Administration")
@Feature("Catalog")
@Story("Manufacturer")
@WebTest
@ExtendWith(DaoExtension.class)
public class AdministrationManufacturesTests {

    private final BaseSteps baseSteps = new BaseSteps();
    private final AdministrationManufacturersPage manufacturersPage = new AdministrationManufacturersPage();
    private final AdministrationManufacturerCreatePage manufacturerCreatePage = new AdministrationManufacturerCreatePage();
    private final AdministrationMenuWidget menuWidget = new AdministrationMenuWidget();
    private final AdministrationHeaderWidget headerWidget = new AdministrationHeaderWidget();
    private final AdministrationModalWidget modalWidget = new AdministrationModalWidget();
    private final AdministrationAlertNotificationWidget alertNotificationWidget = new AdministrationAlertNotificationWidget();
    private final AdministrationDataTableLengthWidget dataTableLengthWidget = new AdministrationDataTableLengthWidget();
    @Dao
    private ManufacturerDAO manufacturerDAO;

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
        ManufacturerEntity manufacturerEntity = new FillManufacturerEntity().fillRequiredFields();
        manufacturerDAO.create(manufacturerEntity);

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_MANUFACTURER);
        manufacturersPage
                .clickEditBtnAtTheManufacturer(manufacturerEntity.getName());
        manufacturerCreatePage
                .pageShouldBeOpened();
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE);
        modalWidget
                .iClickBtn(AdministrationModalButton.DELETE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_MANUFACTURER_HAS_BEEN_DELETED_SUCCESSFULLY);
        manufacturersPage
                .manufacturerShouldNotBeDisplayInTheTable(manufacturerEntity.getName());
    }

    @Test
    @Link(value = "Test case TEAM1-55", url = "https://jira.portnov.com/browse/TEAM1-55")
    void deleteManufacturerFromManufacturersPage() {
        ManufacturerEntity manufacturerEntity = new FillManufacturerEntity().fillRequiredFields();
        manufacturerDAO.create(manufacturerEntity);

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_MANUFACTURER);
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        manufacturersPage
                .selectCheckboxAtTheManufacturer(manufacturerEntity.getName());
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE_SELECTED);
        modalWidget
                .iClickBtn(AdministrationModalButton.YES);
        manufacturersPage
                .manufacturerShouldNotBeDisplayInTheTable(manufacturerEntity.getName());
    }
}
