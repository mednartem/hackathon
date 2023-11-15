package com.portnov.env_sky.logic.pages.administration.categories;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.noneMatch;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdministrationCategoriesPage {
    private final SelenideElement elTable = $("#categories-grid_wrapper");

    @Step("`Categories` page should be opened`")
    public AdministrationCategoriesPage pageShouldBeOpened() {
        elTable.shouldBe(visible);
        return this;
    }

    @Step("The Category with `{name}` should be display in the table")
    public void categoryShouldBeDisplayInTheTable(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).shouldBe(visible);
    }

    @Step("The Category with `{name}` should not display in the table")
    public void categoryShouldNotBeDisplayInTheTable(String name) {
        elTable.$$("tr").shouldBe(noneMatch(
                "The table doesn't have category with name: " + name,
                el -> el.getText().contains(name)
        ));
    }

    @Step("I click the `Edit` button at the category with `{name}`")
    public void clickEditBtnAtTheCategory(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).closest("tr").find(".btn").click();
    }

    @Step("I select checkbox at the category with `{name}`")
    public void selectCheckboxAtTheCategory(String name) {
        elTable.$x(String.format(".//td[text()='%s']", name)).closest("tr").find("[name=checkbox_categories]").click();
    }
}
