package com.automationpractice.pages;

import com.automationpractice.core.BasePage;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.automationpractice.utils.LocatorRepository.getLocator;

public class ConfirmOrderPage extends BasePage {
    private final By CONFIRM_ORDER_BUTTON = getLocator("ConfirmOrderPage.ConfirmOrderButton");
    private final By MESSAGE_BOX = getLocator("ConfirmOrderPage.MessageBox");
    private final By BACK_TO_ORDERS = getLocator("ConfirmOrderPage.BackToOrdersButton");

    public ConfirmOrderPage confirmOrder() {
        $(CONFIRM_ORDER_BUTTON).click();
        return page(ConfirmOrderPage.class);
    }

    public String getOrderReference() {
        Pattern orderReferencePattern = Pattern.compile("(?<=order reference )[A-Z]+");
        String message =  $(MESSAGE_BOX).text();
        Matcher matcher = orderReferencePattern.matcher(message);

        return matcher.find() ? matcher.group() : null;
    }

    public OrderHistoryPage goToOrderHistoryPage() {
        $(BACK_TO_ORDERS).click();
        return page(OrderHistoryPage.class);
    }
}
