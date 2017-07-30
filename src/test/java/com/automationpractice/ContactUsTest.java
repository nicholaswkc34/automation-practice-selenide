package com.automationpractice;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.automationpractice.pages.BasePage.goToHomePage;

public class ContactUsTest extends BaseTest {
    private final String SUBJECT_HEADING = "Customer service";
    private final String EMAIL = "test@gmail.com";
    private final String ORDER_REFERENCE = "ORDREF - 01/01/2000";
    private final String FILE_PATH = "ContactUsAttachment.txt";
    private final String BLANK_MESSAGE_ERROR = "The message cannot be blank";

    @Test(alwaysRun = true)
    @Description("Verifies that contact us form sends successfully")
    public void submitContactUsForm() {
        goToHomePage()
                .goToContactUsPage()
                .submitMessage(SUBJECT_HEADING, EMAIL, ORDER_REFERENCE, FILE_PATH, "Some message text")
                .shouldHaveSuccessMessage();
    }

    @Test(alwaysRun = true)
    @Description("Verifies that error message appears if Message area is empty")
    public void submitContactUsFormWithoutMessageText() {
        goToHomePage()
                .goToContactUsPage()
                .submitMessage(SUBJECT_HEADING, EMAIL, ORDER_REFERENCE, FILE_PATH, "")
                .shouldHaveErrorMessage(BLANK_MESSAGE_ERROR);
    }

}
