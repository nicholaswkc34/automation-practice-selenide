package com.automationpractice;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.automationpractice.pages.BasePage.goToHomePage;

public class AccountTest extends BaseTest {
    private final String MY_ACCOUNT_TITLE = "My account - My Store"; //TODO Replace with page_id checking

    @Test(alwaysRun = true)
    @Description("Verifies the ability to register")
    public void createNewAccount() {
        goToHomePage()
                .goToSignInPage()
                .startAccountCreationWithRandomEmail()
                .createAccountWithRandomInformation()
                .shouldHaveTitle(MY_ACCOUNT_TITLE);
    }
}
