package com.learning.appium.driver;

import com.learning.appium.configuration.AddressConfigurator;
import com.learning.appium.configuration.CapabilitiesConfigurator;
import com.learning.appium.configuration.ConfigurationReader;
import com.learning.appium.configuration.EnvironmentType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Optional;

import static java.lang.String.format;

public class DriverManager {

    private static final Logger log = LogManager.getRootLogger();
    private static final EnvironmentType ENVIRONMENT_TYPE = EnvironmentType.valueOf(ConfigurationReader.get().env().toUpperCase());
    private static AppiumDriver<MobileElement> driver;

    private DriverManager() {

    }

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    public static AppiumDriver<MobileElement> createDriver() {
        switch (ENVIRONMENT_TYPE) {
            case LOCAL:
                driver = new AndroidDriver<MobileElement>(
                        AddressConfigurator.getAppiumDriverLocalService(ConfigurationReader.get().appiumPort()),
                        CapabilitiesConfigurator.getLocalCapabilities());
                break;
            default:
                throw new IllegalArgumentException(format("Unexpected environment value %s", ENVIRONMENT_TYPE));
        }
        log.info("Driver created");
        log.info("Environment type is %s", ENVIRONMENT_TYPE);
        return driver;
    }

    public static void closeDriver() {
        Optional.ofNullable(getDriver()).ifPresent(driverInstance -> {
            driverInstance.quit();
            
            driver = null;
            log.info(("Driver closed"));
        });
    }

    public static void closeAppium() {
        AddressConfigurator.stopService();
    }

    public static void closeEmulator() {
        try {
            Runtime.getRuntime().exec(format("adb -s %s emu kill", ConfigurationReader.get().udid()));
            log.info("AVD closed");
        } catch (IOException e) {
            log.info("AVD was not closed, message: {}", e.getMessage());
        }
    }
}
