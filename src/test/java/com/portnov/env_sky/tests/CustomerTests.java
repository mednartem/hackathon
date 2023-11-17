package com.portnov.env_sky.tests;

import com.portnov.env_sky.logic.dictionary.ui.MenuHeader;
import com.portnov.env_sky.logic.dictionary.ui.ProductShoes;
import com.portnov.env_sky.logic.jupiter.WebTest;
import com.portnov.env_sky.logic.pages.CartPage;
import com.portnov.env_sky.logic.pages.CategoryPage;
import com.portnov.env_sky.logic.pages.ProductPage;
import com.portnov.env_sky.logic.pages.widgets.HeaderMenuWidget;
import com.portnov.env_sky.logic.pages.widgets.HeaderWidget;
import com.portnov.env_sky.logic.rest.model.ProductModel;
import com.portnov.env_sky.logic.pages.BasePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Test;

@Epic("Customer")
@Feature("Cart")
@WebTest
public class CustomerTests {

    private final BasePage basePage = new BasePage();
    private final CategoryPage categoryPage = new CategoryPage();
    private final ProductPage productPage = new ProductPage();
    private final CartPage cartPage = new CartPage();
    private final HeaderWidget headerWidget = new HeaderWidget();
    private final HeaderMenuWidget headerMenuWidget = new HeaderMenuWidget();

    @Test
    @Link(value = "Test case TEAM1-161", url = "https://jira.portnov.com/browse/TEAM1-161")
    void openProductNoAuth() {
        ProductModel productModel = new ProductModel();

        basePage
                .iOpenBasePage();
        headerMenuWidget
                .iHoverMenuInTheHeader(MenuHeader.APPAREL)
                .iClickSubMenuInTheHeader(MenuHeader.SHOES);
        categoryPage
                .pageShouldBeOpened()
                .iOpenRandomItem(productModel);
        productPage
                .openedProductShouldBe(productModel);
    }

    @Test
    @Link(value = "Test case TEAM1-161", url = "https://jira.portnov.com/browse/TEAM1-161")
    void addProductToCartNoAuth() {
        ProductShoes shoe = ProductShoes.ADIDAS_CONSORTIUM_CAMPUS_80S_RUNNING_SHOES;
        int quantity = 1;

        basePage
                .iOpenBasePageWith(shoe.getSlug());
        productPage
                .pageShouldBeOpened()
                .iSelectSize(shoe.getShoesSize())
                .iClickColor(shoe.getShoesColor())
                .iClickAddToCartBtn();
        headerWidget
                .iClickShoppingCartLink();
        cartPage
                .pageShouldBeOpened()
                .numberPositionsShouldBe(quantity)
                .firstProductShouldBe(shoe, quantity);
    }
}
