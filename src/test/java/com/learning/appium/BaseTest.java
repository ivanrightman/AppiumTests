package com.learning.appium;

import com.learning.appium.driver.DriverManager;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeClass
    public void createSession() {
        DriverManager.getDriver();
    }

    @AfterMethod
    public void resetApp() {
        DriverManager.getDriver().resetApp();
    }

    @AfterClass
    public void closeSession() {
        DriverManager.closeDriver();
        DriverManager.closeAppium();
        DriverManager.closeEmulator();
    }
}
