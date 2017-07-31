package com.automationpractice;

import com.automationpractice.core.BaseTest;
import com.automationpractice.pages.ConfirmOrderPage;
import com.automationpractice.pages.SignInPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import io.qameta.allure.Step;

import static com.automationpractice.core.BasePage.goToHomePage;

public class OrderTest extends BaseTest {

    private final String DEFAULT_EMAIL = "TeoRakan@gmail.com";
    private final String DEFAULT_PASSWORD = "GHSZXy28G3skua2SmVi";

    @Test(alwaysRun = true)
    @Description("Verifies the ability to make an order and checks it ih the order history")
    public void makeOrderAndCheckItInOrderHistory() {
        ConfirmOrderPage confirmOrderPage;
        String orderReference;

        if (!goToHomePage().isUserLoggedIn())
            tryLogin(DEFAULT_EMAIL, DEFAULT_PASSWORD);

        addToCartFirstOf("Dress");
        confirmOrderPage = proceedWithBankWirePaymentAndConfirm();
        orderReference = confirmOrderPage.getOrderReference();
        checkOrderInOrderHistory(orderReference);
    }

    @Step("Try to login with '{0}' email amd '{1}' password")
    public void tryLogin(String email, String password) {
        SignInPage signInPage = goToHomePage().goToSignInPage();
        if (!signInPage.tryLogin(email, password)) {
            createNewAccount(signInPage, email, password);
        }
    }

    @Step("Create a new account: {1} : {2}")
    public void createNewAccount(SignInPage signInPage, String email, String password) {
        signInPage.startAccountCreation(email)
                .createAccountWithRandomInformation(password);
    }

    @Step("Add the first of '{0}' from the search results to the shopping cart")
    public void addToCartFirstOf(String product) {
        goToHomePage().addToCartFirstOf(product);
    }

    @Step("Proceed to checkout, select the 'Bank Wire' payment option and confirm")
    public ConfirmOrderPage proceedWithBankWirePaymentAndConfirm() {
        return goToHomePage()
                .goToShoppingCartSummaryPage()
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
