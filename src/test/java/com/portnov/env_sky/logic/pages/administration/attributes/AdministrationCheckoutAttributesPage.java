package com.portnov.env_sky.logic.pages.administration.attributes;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.noneMatch;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdministrationCheckoutAttributesPage {
    private final SelenideElement elTable = $("#checkoutattributes-grid_wrapper");

    @Step("The `Checkout Attributes` page should be opened`")
    public void pageShouldBeOpened() {
        elTable.shouldBe(visible);
    }

    @Step("The Checkout attribute with `{name}` should be display in the table")
    public void checkoutAttributeShouldBeDisplayInTheTable(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).shouldBe(visible);
    }

    @Step("The Checkout attribute with `{name}` should not display in the table")
    public void checkoutAttributeShouldNotBeDisplayInTheTable(String name) {
        elTable.$$("tr").shouldBe(noneMatch(
                "The table doesn't have the checkout attribute with name: " + name,
                el -> el.getText().contains(name)
        ));
    }

    @Step("I click the `Edit` button at the checkout attribute with `{name}`")
    public void clickEditBtnAtTheCheckoutAttribute(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).closest("tr").find(".btn").click();
    }

    @Step("I select checkbox at the checkout attribute with `{name}`")
    public void selectCheckboxAtTheCheckoutAttribute(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).closest("tr").find("[name=checkbox_checkoutattributes]").click();
    }
}
