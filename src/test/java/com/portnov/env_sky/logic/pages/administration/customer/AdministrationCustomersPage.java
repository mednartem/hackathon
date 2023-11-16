package com.portnov.env_sky.logic.pages.administration.customer;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.noneMatch;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdministrationCustomersPage {
    private final SelenideElement elTable = $("#customers-grid_wrapper");

    @Step("The `Customers` page should be opened`")
    public void pageShouldBeOpened() {
        elTable.shouldBe(visible);
    }

    @Step("The Customer with email `{email}` should be display in the table")
    public void customerShouldBeDisplayInTheTable(String email, String name, String company) {
        elTable
                .$x(String.format(".//td[text()='%s']", email))
                .closest("tr")
                .shouldHave(
                        text(email), text(name), text(company)
                );
    }

    @Step("The Customer with `{name}` should not display in the table")
    public void customerShouldNotBeDisplayInTheTable(String name) {
        elTable.$$("tr").shouldBe(noneMatch(
                "The table doesn't have the customer with name: " + name,
                el -> el.getText().contains(name)
        ));
    }

    @Step("I click the `Edit` button at the customer with `{name}`")
    public void clickEditBtnAtTheCustomer(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).closest("tr").find(".btn").click();
    }

    @Step("I select checkbox at the manufacturer with `{name}`")
    public void selectCheckboxAtTheCustomer(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).closest("tr").find("[name=checkbox_customers]").click();
    }
}
