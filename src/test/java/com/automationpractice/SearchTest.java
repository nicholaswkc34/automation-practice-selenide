package com.automationpractice;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.automationpractice.pages.BasePage.goToHomePage;

public class SearchTest extends BaseTest {

    @Test(alwaysRun = true)
    @Description("Verifies the ability to search the item")
    public void searchBlouse() {
        String product = "Blouse";
        goToHomePage()
                .search(product)
                .shouldHaveInSearchResults(product);
    }

    @Test(alwaysRun = true)
    @Description("Verifies the ability to add and delete items from cart")
    public void addAndRemoveProductFromCart() {
        int productId = goToHomePage().addToCartFirstOf("Dress");
        goToHomePage()
                .goToOrderSummaryPage()
                .shouldHaveSize(1)
                .shouldHaveProduct(productId)
                .removeProduct(productId)
                .shouldHaveSize(0);
    }
}
