package com.learning.appium.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static com.learning.appium.driver.DriverManager.getDriver;

public class BasePage {

    protected WebDriverWait wait;
    protected static final int WAIT_TIMEOUT_SECONDS = 15;

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
        wait = new WebDriverWait(getDriver(), WAIT_TIMEOUT_SECONDS);
    }

    public void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
