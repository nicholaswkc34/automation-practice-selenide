package com.automationpractice.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OrderHistoryPage extends BasePage {

    public void shouldHaveOrderReference(String orderReference) {
        $(By.linkText(orderReference)).shouldBe(Condition.exist);
    }
}
