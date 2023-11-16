package com.portnov.env_sky.logic.pages.administration.attributes;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.noneMatch;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdministrationProductAttributesPage {
    private final SelenideElement elTable = $("#products-grid_wrapper");

    @Step("The `Product Attributes` page should be opened`")
    public void pageShouldBeOpened() {
        elTable.shouldBe(visible);
    }

    @Step("The Product attribute with `{name}` should be display in the table")
    public void productAttributeShouldBeDisplayInTheTable(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).shouldBe(visible);
    }

    @Step("The Product attribute with `{name}` should not display in the table")
    public void productAttributeShouldNotBeDisplayInTheTable(String name) {
        elTable.$$("tr").shouldBe(noneMatch(
                "The table doesn't have the product attribute with name: " + name,
                el -> el.getText().contains(name)
        ));
    }

    @Step("I click the `Edit` button at the product attribute with `{name}`")
    public void clickEditBtnAtTheProductAttribute(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).closest("tr").find(".btn").click();
    }

    @Step("I select checkbox at the product attribute with `{name}`")
    public void selectCheckboxAtTheProductAttribute(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).closest("tr").find("[name=checkbox_productattributes]").click();
    }
}
