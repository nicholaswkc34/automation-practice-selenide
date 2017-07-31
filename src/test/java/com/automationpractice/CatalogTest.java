package com.automationpractice;

import com.automationpractice.core.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.automationpractice.core.BasePage.goToHomePage;

public class CatalogTest extends BaseTest {

    @Test(alwaysRun = true)
    @Description("Verifies catalog data")
    public void checkTShirtsPage() {
        goToHomePage()
                .openTShirtsCategory()
                .shouldHaveCategoryResultsSize(1)
                .shouldHaveInCategoryResults("T-shirt");

    }
}
