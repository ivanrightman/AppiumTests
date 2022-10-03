package com.learning.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.stream.Collectors;

public class AccessAccountDetailsPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'password')]")
    private MobileElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'password-confirm')]")
    private MobileElement confirmPasswordField;

    //@AndroidFindBy(id = "kc-login-step2")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'kc-login-step2')]")
    private MobileElement continueButton;

    @AndroidFindBy (xpath = "//*[contains(@resource-id, 'has')]")
    private List<MobileElement> passwordErrors;

    public AccessAccountDetailsPage fillPassword(String input) {
        waitUntilElementVisible(passwordField);
        passwordField.click();
        passwordField.sendKeys(input);
        return this;
    }

    public AccessAccountDetailsPage fillConfirmPassword(String input) {
        confirmPasswordField.click();
        confirmPasswordField.sendKeys(input);
        return this;
    }

    public List<String> getPasswordErrors() {
        return passwordErrors.stream()
                .map(RemoteWebElement::getTagName)
                .collect(Collectors.toList());
    }
}
