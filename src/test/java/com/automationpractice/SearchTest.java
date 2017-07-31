package com.automationpractice;

import com.automationpractice.core.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.automationpractice.core.BasePage.goToHomePage;

public class SearchTest extends BaseTest {

    @Test(alwaysRun = true)
    @Description("Verifies the ability to search the 'Blouse' item")
    public void searchBlouse() {
        String product = "Blouse";
        goToHomePage()
                .search(product)
                .shouldHaveInSearchResults(product);
    }
}
