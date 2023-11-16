package com.portnov.env_sky.tests.administration;

import com.portnov.env_sky.logic.data.FillCheckoutAttributeEntity;
import com.portnov.env_sky.logic.data.RandomData;
import com.portnov.env_sky.logic.db.dao.CheckoutAttributesDAO;
import com.portnov.env_sky.logic.db.model.CheckoutAttributesEntity;
import com.portnov.env_sky.logic.dictionary.ui.administration.*;
import com.portnov.env_sky.logic.jupiter.Dao;
import com.portnov.env_sky.logic.jupiter.DaoExtension;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.administration.attributes.AdministrationCheckoutAttributeCreatePage;
import com.portnov.env_sky.logic.pages.administration.attributes.AdministrationCheckoutAttributesPage;
import com.portnov.env_sky.logic.pages.administration.widgets.AdministrationAlertNotificationWidget;
import com.portnov.env_sky.logic.pages.administration.widgets.AdministrationHeaderWidget;
import com.portnov.env_sky.logic.pages.administration.widgets.AdministrationMenuWidget;
import com.portnov.env_sky.logic.pages.administration.widgets.AdministrationModalWidget;
import com.portnov.env_sky.logic.steps.BaseSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Epic("Administration")
@Feature("Catalog")
@Story("Checkout attributes")
@WebTest
@ExtendWith(DaoExtension.class)
public class AdministrationCheckoutAttributesTests {

    private final BaseSteps baseSteps = new BaseSteps();
    private final AdministrationCheckoutAttributesPage checkoutAttributesPage = new AdministrationCheckoutAttributesPage();
    private final AdministrationCheckoutAttributeCreatePage checkoutAttributeCreatePage = new AdministrationCheckoutAttributeCreatePage();
    private final AdministrationMenuWidget menuWidget = new AdministrationMenuWidget();
    private final AdministrationHeaderWidget headerWidget = new AdministrationHeaderWidget();
    private final AdministrationModalWidget modalWidget = new AdministrationModalWidget();
    private final AdministrationAlertNotificationWidget alertNotificationWidget = new AdministrationAlertNotificationWidget();
    @Dao
    private CheckoutAttributesDAO checkoutAttributesDAO;

    @Test
    void openCheckoutAttributePage() {
        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.DASHBOARD);
        menuWidget
                .iClickMenu(AdministrationMenu.CATALOG)
                .iClickMenu(AdministrationMenu.ATTRIBUTES)
                .iClickMenu(AdministrationMenu.CHECKOUT_ATTRIBUTES);
        checkoutAttributesPage
                .pageShouldBeOpened();
    }

    @Test
    @Link(value = "Test case TEAM1-117", url = "https://jira.portnov.com/browse/TEAM1-117")
    void addNewCheckoutAttributeBasic() {
        String name = RandomData.generateNameCheckoutAttribute();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CHECKOUT_ATTRIBUTE_LIST);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.ADD_NEW);
        checkoutAttributeCreatePage
                .iTypeName(name);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_ATTRIBUTE_HAS_BEEN_ADDED_SUCCESSFULLY);
        checkoutAttributesPage
                .pageShouldBeOpened();
        checkoutAttributesPage
                .checkoutAttributeShouldBeDisplayInTheTable(name);
    }

    @Test
    @Disabled("Created entity doesn't display in UI. Need to investigate")
    @Link(value = "Test case TEAM1-118", url = "https://jira.portnov.com/browse/TEAM1-118")
    void deleteCheckoutAttributeFromEditForm() {
        CheckoutAttributesEntity checkoutAttributes = new FillCheckoutAttributeEntity().fillRequiredFields();
        checkoutAttributesDAO.create(checkoutAttributes);

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CHECKOUT_ATTRIBUTE_LIST);
        checkoutAttributesPage
                .clickEditBtnAtTheCheckoutAttribute(checkoutAttributes.getName());
        checkoutAttributeCreatePage
                .pageShouldBeOpened();
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE);
        modalWidget
                .iClickBtn(AdministrationModalButton.DELETE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_ATTRIBUTE_HAS_BEEN_DELETED_SUCCESSFULLY);
        checkoutAttributesPage
                .checkoutAttributeShouldNotBeDisplayInTheTable(checkoutAttributes.getName());
    }

    @Test
    @Disabled("Created entity doesn't display in UI. Need to investigate")
    @Link(value = "Test case TEAM1-119", url = "https://jira.portnov.com/browse/TEAM1-119")
    void deleteCheckoutAttributeFromProductAttributesPage() {
        CheckoutAttributesEntity checkoutAttributes = new FillCheckoutAttributeEntity().fillRequiredFields();
        checkoutAttributesDAO.create(checkoutAttributes);

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CHECKOUT_ATTRIBUTE_LIST);
        checkoutAttributesPage
                .selectCheckboxAtTheCheckoutAttribute(checkoutAttributes.getName());
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE_SELECTED);
        modalWidget
                .iClickBtn(AdministrationModalButton.YES);
        checkoutAttributesPage
                .checkoutAttributeShouldNotBeDisplayInTheTable(checkoutAttributes.getName());
    }
}
