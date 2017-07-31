package com.automationpractice;

import com.automationpractice.core.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.automationpractice.core.BasePage.goToHomePage;

public class AccountTest extends BaseTest {

    @Test(alwaysRun = true)
    @Description("Verifies the ability to register")
    public void createNewAccount() {
        goToHomePage()
                .goToSignInPage()
                .startAccountCreationWithRandomEmail()
                .createAccountWithRandomInformation()
                .shouldBeAppear();
    }
}
