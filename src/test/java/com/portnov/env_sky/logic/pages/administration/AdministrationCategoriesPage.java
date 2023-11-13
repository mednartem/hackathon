package com.portnov.env_sky.logic.pages.administration;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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
}
