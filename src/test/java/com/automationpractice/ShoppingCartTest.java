package com.automationpractice;

import com.automationpractice.core.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.automationpractice.core.BasePage.goToHomePage;

public class ShoppingCartTest extends BaseTest {

    @Test(alwaysRun = true)
    @Description("Verifies the ability to add and delete items from cart")
    public void addAndRemoveProductFromCart() {
        int productId = goToHomePage().addToCartFirstOf("Summer dress");
        goToHomePage()
                .goToShoppingCartSummaryPage()
                .shouldHaveSize(1)
                .shouldHaveProduct(productId)
                .removeProduct(productId)
                .shouldHaveSize(0);
    }
}
