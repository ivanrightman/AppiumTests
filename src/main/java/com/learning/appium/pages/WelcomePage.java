package com.learning.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomePage extends BasePage {

    @AndroidFindBy(accessibility = "onBoarding-btn-skip")
    private MobileElement skipButton;

    public LoginPage clickSkipButton() {
        waitUntilElementVisible(skipButton);
        skipButton.click();
        return new LoginPage();
    }
}
