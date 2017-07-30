package com.automationpractice.utils;

import org.openqa.selenium.By;

import java.io.InputStream;
import java.util.Properties;

public class LocatorRepository {

    private static Properties locators;

    static {
        locators = new Properties();
        InputStream is = LocatorRepository.class.getResourceAsStream("/locators.properties");
        try {
            locators.load(is);
        } catch (Exception e) {
            System.out.println("Error in loading the properties file: " + e.getMessage());
        }
    }

    public static By getParametrizedLocator(String locator, int param) {
        String propertyValue = locators.getProperty(locator);
        String parametrizedValue = String.format(propertyValue, param);
        return parseLocatorProperty(parametrizedValue);
    }

    public static By getLocator(String locator) {
        String propertyValue = locators.getProperty(locator);
        return parseLocatorProperty(propertyValue);
    }

    protected static By parseLocatorProperty(String propertyValue) {
        String [] locatorParts = propertyValue.split(":", 2);
        String locatorType = locatorParts[0].trim();
        String locatorValue = locatorParts[1].trim();

        switch (locatorType) {
            case "id":
                return By.id(locatorValue);
            case "name":
                return By.name(locatorValue);
            case "css":
                return By.cssSelector(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
            case "class":
                return By.className(locatorValue);
            case "tag":
                return By.tagName(locatorValue);
            case "link":
                return By.linkText(locatorValue);
            case "partLink":
                return By.partialLinkText(locatorValue);
            default:
                throw new IllegalArgumentException("Unknown locator type: " + locatorType);
        }
    }
}
