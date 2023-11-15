package com.portnov.env_sky.logic.pages.administration.manufacturer;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.noneMatch;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdministrationManufacturersPage {
    private final SelenideElement elTable = $("#manufacturers-grid_wrapper");

    @Step("The `Manufacturer` page should be opened`")
    public void pageShouldBeOpened() {
        elTable.shouldBe(visible);
    }

    @Step("The Manufacturer with `{name}` should be display in the table")
    public void manufacturerShouldBeDisplayInTheTable(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).shouldBe(visible);
    }

    @Step("The Manufacturer with `{name}` should not display in the table")
    public void manufacturerShouldNotBeDisplayInTheTable(String name) {
        elTable.$$("tr").shouldBe(noneMatch(
                "The table doesn't have the manufacturer with name: " + name,
                el -> el.getText().contains(name)
        ));
    }

    @Step("I click the `Edit` button at the manufacturer with `{name}`")
    public void clickEditBtnAtTheManufacturer(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).closest("tr").find(".btn").click();
    }

    @Step("I select checkbox at the manufacturer with `{name}`")
    public void selectCheckboxAtTheManufacturer(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).closest("tr").find("[name=checkbox_manufacturers]").click();
    }
}
