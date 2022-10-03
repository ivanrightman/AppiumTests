package com.learning.appium;

import com.learning.appium.pages.AccessAccountDetailsPage;
import com.learning.appium.pages.AccessWelcomePage;
import com.learning.appium.pages.LoginPage;
import com.learning.appium.pages.WelcomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.String.format;

public class LoginTest extends BaseTest {

    private static final String REQUIRED_IN_VALUE = "at least";

    @Test
    public void checkPasswordErrors() {
        WelcomePage welcomePage = new WelcomePage();
        LoginPage loginPage = new LoginPage();
        AccessWelcomePage accessWelcomePage = new AccessWelcomePage();
        AccessAccountDetailsPage accessAccountDetailsPage = new AccessAccountDetailsPage();
        welcomePage.clickSkipButton();
        loginPage.clickLoginButton();
        accessWelcomePage.fillLogin("lorem@lorem.com");
        accessWelcomePage.clickContinueButton();
        accessAccountDetailsPage.fillPassword("ipsum");
        SoftAssert softAssert = new SoftAssert();
        accessAccountDetailsPage.getPasswordErrors().forEach(value ->
                softAssert.assertTrue(value.contains(REQUIRED_IN_VALUE), format ("Error %s doesn't contain value %s", value, REQUIRED_IN_VALUE)));
        softAssert.assertAll();
    }
}
