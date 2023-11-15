package com.portnov.env_sky.tests.administration;

import com.portnov.env_sky.logic.db.dao.impl.ProductDAOJdbc;
import com.portnov.env_sky.logic.dictionary.ui.administration.*;
import com.portnov.env_sky.logic.data.RandomData;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.administration.products.AdministrationProductCreatePage;
import com.portnov.env_sky.logic.pages.administration.products.AdministrationProductsPage;
import com.portnov.env_sky.logic.pages.administration.widgets.*;
import com.portnov.env_sky.logic.steps.BaseSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Epic("Administration")
@Feature("Catalog")
@Story("Products")
@WebTest
public class AdministrationProductsTests {

    private final BaseSteps baseSteps = new BaseSteps();
    private final AdministrationProductsPage productsPage = new AdministrationProductsPage();
    private final AdministrationProductCreatePage productCreatePage = new AdministrationProductCreatePage();
    private final AdministrationMenuWidget menuWidget = new AdministrationMenuWidget();
    private final AdministrationHeaderWidget headerWidget = new AdministrationHeaderWidget();
    private final AdministrationModalWidget modalWidget = new AdministrationModalWidget();
    private final AdministrationAlertNotificationWidget alertNotificationWidget = new AdministrationAlertNotificationWidget();
    private final AdministrationDataTableLengthWidget dataTableLengthWidget = new AdministrationDataTableLengthWidget();
    private final ProductDAOJdbc productDAOJdbc = new ProductDAOJdbc();

    @Test
    void openProductsPage() {
        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.DASHBOARD);
        menuWidget
                .iClickMenu(AdministrationMenu.CATALOG)
                .iClickMenu(AdministrationMenu.PRODUCTS);
        productsPage
                .pageShouldBeOpened();
    }

    @Test
    @Link(value = "Test case TEAM1-46", url = "https://jira.portnov.com/browse/TEAM1-46")
    void addNewProductBasic() {
        String name = RandomData.generateNameProduct();
        String description = RandomData.generateDescriptionProduct();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_PRODUCTS);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.ADD_NEW);
        productCreatePage
                .iTypeName(name)
                .iTypeShortDescription(description);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_PRODUCT_HAS_BEEN_ADDED_SUCCESSFULLY);
        productsPage
                .pageShouldBeOpened();
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        productsPage
                .productShouldBeDisplayInTheTable(name);
    }

    @Test
    @Link(value = "Test case TEAM1-125", url = "https://jira.portnov.com/browse/TEAM1-125")
    void deleteProductFromEditForm() {
        String name = productDAOJdbc.create().getName();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_PRODUCTS);
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        productsPage
                .clickEditBtnAtTheProduct(name);
        productCreatePage
                .pageShouldBeOpened();
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE);
        modalWidget
                .iClickBtn(AdministrationModalButton.DELETE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_PRODUCT_HAS_BEEN_DELETED_SUCCESSFULLY);
        productsPage
                .productShouldNotBeDisplayInTheTable(name);
    }

    @Test
    @Link(value = "Test case TEAM1-126", url = "https://jira.portnov.com/browse/TEAM1-126")
    void deleteProductFromProductsPage() {
        String name = productDAOJdbc.create().getName();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_PRODUCTS);
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        productsPage
                .selectCheckboxAtTheProduct(name);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE_SELECTED);
        modalWidget
                .iClickBtn(AdministrationModalButton.YES);
        productsPage
                .productShouldNotBeDisplayInTheTable(name);
    }
}
