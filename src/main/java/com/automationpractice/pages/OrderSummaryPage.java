package com.automationpractice.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;
import static com.automationpractice.utils.LocatorRepository.getLocator;
import static com.automationpractice.utils.LocatorRepository.getParametrizedLocator;

public class OrderSummaryPage extends BasePage {
    private final By PROCEED_TO_CHECKOUT_BUTTON = getLocator("SummaryOrderPage.ProceedToCheckoutButton");
    private final By PRODUCT_ROW = getLocator("SummaryOrderPage.ProductRow");
    private final String REMOVE_PRODUCT_PARAMETRIZED = "SummaryOrderPage.RemoveProductButton.Parametrized";
    private final String PRODUCT_ROW_PARAMETRIZED = "SummaryOrderPage.ProductRow.Parametrized";

    public AddressPage proceedAndGoToAddressPage() {
        $(PROCEED_TO_CHECKOUT_BUTTON).click();
        return page(AddressPage.class);
    }
    
    public OrderSummaryPage shouldHaveSize(int size) {
        $$(PRODUCT_ROW).shouldHaveSize(size);
        return this;
    }

    public OrderSummaryPage shouldHaveProduct(int id) {
        By productRow = getParametrizedLocator(PRODUCT_ROW_PARAMETRIZED, id);
        $(productRow).shouldBe(Condition.exist);
        return this;
    }

    public OrderSummaryPage removeProduct(int id) {
        By removeButton = getParametrizedLocator(REMOVE_PRODUCT_PARAMETRIZED, id);
        $(removeButton).click();
        return page(OrderSummaryPage.class);
    }
}
