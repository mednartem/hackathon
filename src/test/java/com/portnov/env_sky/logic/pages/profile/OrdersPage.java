package com.portnov.env_sky.logic.pages.profile;

import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OrdersPage {

    @Step("The `My Account - Orders` page should be opened`")
    public OrdersPage pageShouldBeOpened() {
        $(".order-list-page").shouldBe(visible);
        return this;
    }

    @Step("Number of order items should be `{size}`")
    public OrdersPage numberOfOrderItemsShouldBe(int size) {
        $$(".order-item").shouldHave(size(size));
        return this;
    }
}
