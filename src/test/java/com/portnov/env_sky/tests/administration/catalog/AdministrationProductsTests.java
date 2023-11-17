package com.portnov.env_sky.tests.administration.catalog;

import com.portnov.env_sky.logic.data.FillProductModelEntity;
import com.portnov.env_sky.logic.data.RandomData;
import com.portnov.env_sky.logic.db.dao.ProductDAO;
import com.portnov.env_sky.logic.db.model.ProductEntity;
import com.portnov.env_sky.logic.dictionary.ui.administration.*;
import com.portnov.env_sky.logic.jupiter.Dao;
import com.portnov.env_sky.logic.jupiter.DaoExtension;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.administration.products.AdministrationProductCreatePage;
import com.portnov.env_sky.logic.pages.administration.products.AdministrationProductsPage;
import com.portnov.env_sky.logic.pages.administration.widgets.*;
import com.portnov.env_sky.logic.pages.BasePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Epic("Administration")
@Feature("Catalog")
@Story("Products")
@WebTest
@ExtendWith(DaoExtension.class)
public class AdministrationProductsTests {

    private final BasePage basePage = new BasePage();
    private final AdministrationProductsPage productsPage = new AdministrationProductsPage();
    private final AdministrationProductCreatePage productCreatePage = new AdministrationProductCreatePage();
    private final AdministrationMenuWidget menuWidget = new AdministrationMenuWidget();
    private final AdministrationHeaderWidget headerWidget = new AdministrationHeaderWidget();
    private final AdministrationModalWidget modalWidget = new AdministrationModalWidget();
    private final AdministrationAlertNotificationWidget alertNotificationWidget = new AdministrationAlertNotificationWidget();
    private final AdministrationDataTableLengthWidget dataTableLengthWidget = new AdministrationDataTableLengthWidget();
    @Dao
    private ProductDAO productDAO;

    @Test
    void openProductsPage() {
        basePage
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

        basePage
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
        ProductEntity productEntity = new FillProductModelEntity().fillRequiredFields();
        productDAO.create(productEntity);

        basePage
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_PRODUCTS);
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        productsPage
                .clickEditBtnAtTheProduct(productEntity.getName());
        productCreatePage
                .pageShouldBeOpened();
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE);
        modalWidget
                .iClickBtn(AdministrationModalButton.DELETE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_PRODUCT_HAS_BEEN_DELETED_SUCCESSFULLY);
        productsPage
                .productShouldNotBeDisplayInTheTable(productEntity.getName());
    }

    @Test
    @Link(value = "Test case TEAM1-126", url = "https://jira.portnov.com/browse/TEAM1-126")
    void deleteProductFromProductsPage() {
        ProductEntity productEntity = new FillProductModelEntity().fillRequiredFields();
        productDAO.create(productEntity);

        basePage
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_PRODUCTS);
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        productsPage
                .selectCheckboxAtTheProduct(productEntity.getName());
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE_SELECTED);
        modalWidget
                .iClickBtn(AdministrationModalButton.YES);
        productsPage
                .productShouldNotBeDisplayInTheTable(productEntity.getName());
    }
}
