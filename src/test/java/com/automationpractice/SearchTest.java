package com.automationpractice;

import com.automationpractice.core.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.automationpractice.core.BasePage.goToHomePage;

public class SearchTest extends BaseTest {

    @DataProvider
    private Object[][] itemSearchQueriesProvider() {
        return new Object[][]{
                {"Blouse"}, {"T-shirt"}, {"Printed Chiffon Dress"}
        };
    }

    @Test(alwaysRun = true, dataProvider = "itemSearchQueriesProvider")
    @Description("Verifies the ability to search items")
    public void parametrizedSearch(String item) {
        goToHomePage()
                .shouldHaveSearchResultsSize(0)
                .search(item)
                .shouldHaveInSearchResults(item);
    }
}
