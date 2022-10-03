package com.learning.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AccessWelcomePage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'username')]")
    private MobileElement loginField;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'kc-login-next')]")
    private MobileElement continueButton;

    public AccessWelcomePage fillLogin(String input) {
        waitUntilElementVisible(loginField);
        loginField.sendKeys(input);
        return this;
    }

    public AccessAccountDetailsPage clickContinueButton() {
        continueButton.click();
        return new AccessAccountDetailsPage();
    }
}
