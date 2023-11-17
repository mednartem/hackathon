package com.portnov.env_sky.tests.administration.catalog;

import com.portnov.env_sky.logic.data.FillProductAttributeEntity;
import com.portnov.env_sky.logic.data.RandomData;
import com.portnov.env_sky.logic.db.dao.ProductAttributesDAO;
import com.portnov.env_sky.logic.db.model.ProductAttributesEntity;
import com.portnov.env_sky.logic.dictionary.ui.administration.*;
import com.portnov.env_sky.logic.jupiter.Dao;
import com.portnov.env_sky.logic.jupiter.DaoExtension;
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
import org.junit.jupiter.api.extension.ExtendWith;

@Epic("Administration")
@Feature("Catalog")
@Story("Product attributes")
@WebTest
@ExtendWith(DaoExtension.class)
public class AdministrationProductAttributesTests {

    private final BaseSteps baseSteps = new BaseSteps();
    private final AdministrationProductAttributesPage productAttributesPage = new AdministrationProductAttributesPage();
    private final AdministrationProductAttributeCreatePage productAttributeCreatePage = new AdministrationProductAttributeCreatePage();
    private final AdministrationMenuWidget menuWidget = new AdministrationMenuWidget();
    private final AdministrationHeaderWidget headerWidget = new AdministrationHeaderWidget();
    private final AdministrationModalWidget modalWidget = new AdministrationModalWidget();
    private final AdministrationAlertNotificationWidget alertNotificationWidget = new AdministrationAlertNotificationWidget();
    private final AdministrationDataTableLengthWidget dataTableLengthWidget = new AdministrationDataTableLengthWidget();
    @Dao
    private ProductAttributesDAO productAttributesDAO;

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
        ProductAttributesEntity productAttributesEntity = new FillProductAttributeEntity().fillRequiredFields();
        productAttributesDAO.create(productAttributesEntity);

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_PRODUCT_ATTRIBUTE);
        productAttributesPage
                .clickEditBtnAtTheProductAttribute(productAttributesEntity.getName());
        productAttributeCreatePage
                .pageShouldBeOpened();
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE);
        modalWidget
                .iClickBtn(AdministrationModalButton.DELETE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_ATTRIBUTE_HAS_BEEN_DELETED_SUCCESSFULLY);
        productAttributesPage
                .productAttributeShouldNotBeDisplayInTheTable(productAttributesEntity.getName());
    }

    @Test
    @Link(value = "Test case TEAM1-99", url = "https://jira.portnov.com/browse/TEAM1-99")
    void deleteProductAttributeFromProductAttributesPage() {
        ProductAttributesEntity productAttributesEntity = new FillProductAttributeEntity().fillRequiredFields();
        productAttributesDAO.create(productAttributesEntity);

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CATALOG_PRODUCT_ATTRIBUTE);
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        productAttributesPage
                .selectCheckboxAtTheProductAttribute(productAttributesEntity.getName());
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE_SELECTED);
        modalWidget
                .iClickBtn(AdministrationModalButton.YES);
        productAttributesPage
                .productAttributeShouldNotBeDisplayInTheTable(productAttributesEntity.getName());
    }
}
