package com.learning.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

    @AndroidFindBy(accessibility = "login-btn-login")
    private MobileElement loginButton;

    @AndroidFindBy(accessibility = "login-btn-signUp")
    private MobileElement signupButton;


    public LoginPage clickLoginButton() {
        waitUntilElementVisible(loginButton);
        loginButton.click();
        return this;
    }
}
