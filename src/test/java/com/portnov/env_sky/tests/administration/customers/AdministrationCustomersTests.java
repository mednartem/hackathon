package com.portnov.env_sky.tests.administration.customers;

import com.portnov.env_sky.logic.data.FillCustomerEntity;
import com.portnov.env_sky.logic.data.RandomData;
import com.portnov.env_sky.logic.db.dao.CustomerDAO;
import com.portnov.env_sky.logic.db.model.CustomerEntity;
import com.portnov.env_sky.logic.dictionary.ui.administration.*;
import com.portnov.env_sky.logic.jupiter.Dao;
import com.portnov.env_sky.logic.jupiter.DaoExtension;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.administration.customer.AdministrationCustomerCreatePage;
import com.portnov.env_sky.logic.pages.administration.customer.AdministrationCustomersPage;
import com.portnov.env_sky.logic.pages.administration.widgets.*;
import com.portnov.env_sky.logic.steps.BaseSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Epic("Administration")
@Feature("Customers")
@Story("Customers")
@WebTest
@ExtendWith(DaoExtension.class)
public class AdministrationCustomersTests {

    private final BaseSteps baseSteps = new BaseSteps();
    private final AdministrationCustomersPage customersPage = new AdministrationCustomersPage();
    private final AdministrationCustomerCreatePage customerCreatePage = new AdministrationCustomerCreatePage();
    private final AdministrationMenuWidget menuWidget = new AdministrationMenuWidget();
    private final AdministrationHeaderWidget headerWidget = new AdministrationHeaderWidget();
    private final AdministrationModalWidget modalWidget = new AdministrationModalWidget();
    private final AdministrationAlertNotificationWidget alertNotificationWidget = new AdministrationAlertNotificationWidget();
    private final AdministrationDataTableLengthWidget dataTableLengthWidget = new AdministrationDataTableLengthWidget();
    @Dao
    private CustomerDAO customerDAO;

    @Test
    void openCustomersPage() {
        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.DASHBOARD);
        menuWidget
                .iClickMenu(AdministrationMenu.CUSTOMERS)
                .iClickSubMenu(AdministrationMenu.CUSTOMERS);
        customersPage
                .pageShouldBeOpened();
    }

    @Test
    @Link(value = "Test case TEAM1-17", url = "https://jira.portnov.com/browse/TEAM1-17")
    void addNewCustomer() {
        String email = RandomData.generateUniqEmail();
        String password = RandomData.generatePassword();
        String firstName = RandomData.generateFirstName();
        String lastName = RandomData.generateLastName();
        String companyName = RandomData.generateCompanyName();

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CUSTOMERS_CUSTOMERS_LIST);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.ADD_NEW);
        customerCreatePage
                .iTypeEmail(email)
                .iTypePassword(password)
                .iTypeFirstName(firstName)
                .iTypeLastName(lastName)
                .iSelectMaleGender()
                .iTypeCompanyName(companyName);
        headerWidget
                .iClickBtn(AdministrationHeaderButton.SAVE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_NEW_CUSTOMER_HAS_BEEN_ADDED_SUCCESSFULLY);
        customersPage
                .pageShouldBeOpened();
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        customersPage
                .customerShouldBeDisplayInTheTable(email, firstName + " " + lastName, companyName);
    }

    @Test
    @Disabled("Need to look into why the created customer via SQL doesn't appear in the UI table")
    @Link(value = "Test case TEAM1-23", url = "https://jira.portnov.com/browse/TEAM1-23")
    void deleteCustomerFromEditForm() {
        CustomerEntity customerEntity = new FillCustomerEntity().fillRequiredFields();
        customerDAO.create(customerEntity);

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CUSTOMERS_CUSTOMERS_LIST);
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        customersPage
                .clickEditBtnAtTheCustomer(customerEntity.getEmail());
        customerCreatePage
                .pageShouldBeOpened();
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE);
        modalWidget
                .iClickBtn(AdministrationModalButton.DELETE);
        alertNotificationWidget
                .alertNotificationShouldBeVisible(AdministrationAlertNotification.THE_CUSTOMER_HAS_BEEN_DELETED_SUCCESSFULLY);
        customersPage
                .customerShouldNotBeDisplayInTheTable(customerEntity.getEmail());
    }

    @Test
    @Disabled("Need to look into why the created customer via SQL doesn't appear in the UI table")
    void deleteCustomerFromCustomersPage() {
        CustomerEntity customerEntity = new FillCustomerEntity().fillRequiredFields();
        customerDAO.create(customerEntity);

        baseSteps
                .iOpenBasePageWithAdminCookie(AdministrationEndpointUi.CUSTOMERS_CUSTOMERS_LIST);
        dataTableLengthWidget
                .iSelectLength(AdministrationDataTableLength.HUNDRED);
        customersPage
                .selectCheckboxAtTheCustomer(customerEntity.getEmail());
        headerWidget
                .iClickBtn(AdministrationHeaderButton.DELETE_SELECTED);
        modalWidget
                .iClickBtn(AdministrationModalButton.YES);
        customersPage
                .customerShouldNotBeDisplayInTheTable(customerEntity.getEmail());
    }
}
