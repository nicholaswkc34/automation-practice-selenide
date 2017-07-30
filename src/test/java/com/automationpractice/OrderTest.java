package com.automationpractice;

import com.automationpractice.pages.ConfirmOrderPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import io.qameta.allure.Step;

import static com.automationpractice.pages.BasePage.goToHomePage;

public class OrderTest extends BaseTest {

    @Test(alwaysRun = true)
    @Description("Verifies the ability to make an order and checks it ih the order history")
    public void makeOrderAndCheckItInOrderHistory() {
        ConfirmOrderPage confirmOrderPage;
        String orderReference;

        if (!goToHomePage().isUserLoggedIn())
            createNewAccount();

        addToCartFirstOf("Dress");
        confirmOrderPage = proceedWithBankWirePaymentAndConfirm();
        orderReference = confirmOrderPage.getOrderReference();
        checkOrderInOrderHistory(orderReference);
    }

    @Step("Create a new account with the random data")
    public void createNewAccount() {
        goToHomePage()
                .goToSignInPage()
                .startAccountCreationWithRandomEmail()
                .createAccountWithRandomInformation();
    }

    @Step("Add the first of '{0}' from the search results to the shopping cart")
    public void addToCartFirstOf(String product) {
        goToHomePage().addToCartFirstOf(product);
    }

    @Step("Proceed to checkout, select the 'Bank Wire' payment option and confirm")
    public ConfirmOrderPage proceedWithBankWirePaymentAndConfirm() {
        return goToHomePage()
                .goToOrderSummaryPage()
                .proceedAndGoToAddressPage()
                .proceedAndGoToShippingPage()
                .proceedAndGoToPaymentMethodPage()
                .selectBankWirePayment()
                .confirmOrder();
    }

    @Step("Check the '{0}' order reference in the order history")
    public void checkOrderInOrderHistory(String orderReference) {
        goToHomePage()
                .goToAccountPage()
                .goToOrderHistoryPage()
                .shouldHaveOrderReference(orderReference);
    }
}
