package com.portnov.env_sky.tests;

import com.portnov.env_sky.logic.config.ProjectConfig;
import com.portnov.env_sky.logic.data.RandomData;
import com.portnov.env_sky.logic.dictionary.ui.EndpointsUi;
import com.portnov.env_sky.logic.dictionary.ui.MyAccountMenu;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.BasePage;
import com.portnov.env_sky.logic.pages.profile.AddressesPage;
import com.portnov.env_sky.logic.pages.profile.CustomerInfoPage;
import com.portnov.env_sky.logic.pages.header.HeaderWidget;
import com.portnov.env_sky.logic.pages.profile.MyAccountMenuWidget;
import com.portnov.env_sky.logic.pages.profile.OrdersPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Test;

@Epic("Customer")
@Feature("My Account")
@WebTest
public class MyAccountTests {

    private final BasePage basePage = new BasePage();
    private final CustomerInfoPage customerInfoPage = new CustomerInfoPage();
    private final AddressesPage addressesPage = new AddressesPage();
    private final OrdersPage ordersPage = new OrdersPage();
    private final MyAccountMenuWidget myAccountMenuWidget = new MyAccountMenuWidget();
    private final HeaderWidget headerWidget = new HeaderWidget();

    @Test
    @Link(value = "Test case TEAM1-81", url = "https://jira.portnov.com/browse/TEAM1-81")
    void editCustomerInfo() {
        String company = RandomData.generateCompanyName();

        basePage
                .iOpenBasePageWithUserCookie();
        headerWidget
                .iClickMyAccountLink();
        customerInfoPage
                .pageShouldBeOpened()
                .iTypeCompanyName(company)
                .iClickSaveBtn()
                .companyNameShouldBe(company);
    }

    @Test
    @Link(value = "Test case TEAM1-91", url = "https://jira.portnov.com/browse/TEAM1-91")
    void viewCustomerAddress() {
        //todo need create user and get model with data
        String name = "Team Sky";
        String email = ProjectConfig.credential.adminEmail();
        String phone = "1231231233";
        String fax = "123321";
        String address1 = "12s";
        String city = "asad";
        String state = "Alabama";
        String zip = "93044";
        String country = "United States of America";

        basePage
                .iOpenBasePageWithAdminCookie(EndpointsUi.CUSTOMER_INFO);
        myAccountMenuWidget
                .iClickMenu(MyAccountMenu.ADDRESSES);
        addressesPage
                .pageShouldBeOpened()
                .nameShouldBe(name)
                .emailShouldBe(email)
                .phoneShouldBe(phone)
                .faxShouldBe(fax)
                .address1ShouldBe(address1)
                .cityStateZipShouldBe(city, state, zip)
                .countryShouldBe(country);
    }

    @Test
    @Link(value = "Test case TEAM1-104", url = "https://jira.portnov.com/browse/TEAM1-104")
    void viewOrderHistory() {
        int numberOrders = 3;

        basePage
                .iOpenBasePageWithAdminCookie(EndpointsUi.CUSTOMER_INFO);
        myAccountMenuWidget
                .iClickMenu(MyAccountMenu.ORDERS);
        ordersPage
                .pageShouldBeOpened()
                .numberOfOrderItemsShouldBe(numberOrders);
    }
}
