package com.portnov.env_sky.tests.administration;

import com.portnov.env_sky.logic.db.dao.impl.ProductAttributesDAOJdbc;
import com.portnov.env_sky.logic.dictionary.ui.administration.*;
import com.portnov.env_sky.logic.data.RandomData;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.administration.attributes.AdministrationProductAttributeCreatePage;
import com.portnov.env_sky.logic.pages.administration.attributes.AdministrationProductAttributesPage;
import com.portnov.env_sky.logic.pages.administration.widgets.*;
import com.portnov.env_sky.logic.steps.BaseSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Epic("Administration")
@Feature("Catalog")
@Story("Product attributes")
@WebTest
public class AdministrationProductAttributesTests {

    private final BaseSteps baseSteps = new BaseSteps();
    private final AdministrationProductAttributesPage productAttributesPage = new AdministrationProductAttributesPage();
    private final AdministrationProductAttributeCreatePage productAttributeCreatePage = new AdministrationProductAttributeCreatePage();
    private final AdministrationMenuWidget menuWidget = new AdministrationMenuWidget();
    private final AdministrationHeaderWidget headerWidget = new AdministrationHeaderWidget();
    private final AdministrationModalWidget modalWidget = new AdministrationModalWidget();
    private final AdministrationAlertNotificationWidget alertNotificationWidget = new AdministrationAlertNotificationWidget();
    private final AdministrationDataTableLengthWidget dataTableLengthWidget = new AdministrationDataTableLengthWidget();
    private final ProductAttributesDAOJdbc productAttributesDAOJdbc = new ProductAttributesDAOJdbc();

    @Test
    void openProductAttributePage() {
        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.DASHBOARD);
        menuWidget
                .iClickMenu(AdministrationMenu.CATALOG)
                .iClickMenu(AdministrationMenu.ATTRIBUTES)
                .iClickMenu(AdministrationMenu.PRODUCT_ATTRIBUTES);
        productAttributesPage
                .pageShouldBeOpened();
    }

    @Test
    @Link(value = "Test case TEAM1-64", url = "https://jira.portnov.com/browse/TEAM1-64")
    void addNewProductAttributeBasic() {
        String name = RandomData.generateNameManufacturer();
        String description = RandomData.generateDescriptionManufacturer();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_PRODUCT_ATTRIBUTE);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.ADD_NEW);
        productAttributeCreatePage
                .iTypeName(name)
                .iTypeDescription(description);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_ATTRIBUTE_HAS_BEEN_ADDED_SUCCESSFULLY);
        productAttributesPage
                .pageShouldBeOpened();
        productAttributesPage
                .productAttributeShouldBeDisplayInTheTable(name);
    }

    @Test
    @Link(value = "Test case TEAM1-96", url = "https://jira.portnov.com/browse/TEAM1-96")
    void deleteProductAttributeFromEditForm() {
        String name = productAttributesDAOJdbc.create().getName();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_PRODUCT_ATTRIBUTE);
        productAttributesPage
                .clickEditBtnAtTheProductAttribute(name);
        productAttributeCreatePage
                .pageShouldBeOpened();
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE);
        modalWidget
                .iClickBtn(AdministrationModalButton.DELETE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_ATTRIBUTE_HAS_BEEN_DELETED_SUCCESSFULLY);
        productAttributesPage
                .productAttributeShouldNotBeDisplayInTheTable(name);
    }

    @Test
    @Link(value = "Test case TEAM1-99", url = "https://jira.portnov.com/browse/TEAM1-99")
    void deleteProductAttributeFromProductAttributesPage() {
        String name = productAttributesDAOJdbc.create().getName();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_PRODUCT_ATTRIBUTE);
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        productAttributesPage
                .selectCheckboxAtTheProductAttribute(name);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE_SELECTED);
        modalWidget
                .iClickBtn(AdministrationModalButton.YES);
        productAttributesPage
                .productAttributeShouldNotBeDisplayInTheTable(name);
    }
}
