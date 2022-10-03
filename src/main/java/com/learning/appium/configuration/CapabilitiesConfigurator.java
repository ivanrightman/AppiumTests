package com.learning.appium.configuration;

import org.openqa.selenium.remote.DesiredCapabilities;


import static io.appium.java_client.remote.AndroidMobileCapabilityType.*;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.AVD;
import static io.appium.java_client.remote.MobileCapabilityType.*;

public class CapabilitiesConfigurator {

    private CapabilitiesConfigurator() {

    }

    public static DesiredCapabilities getLocalCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(UDID, ConfigurationReader.get().udid());
        capabilities.setCapability(AVD, ConfigurationReader.get().localDeviceName());
        capabilities.setCapability(APP_PACKAGE, ConfigurationReader.get().appPackage());
        capabilities.setCapability(APP_ACTIVITY, ConfigurationReader.get().appActivity());
        capabilities.setCapability(AUTOMATION_NAME, ConfigurationReader.get().automationName());
        capabilities.setCapability(DISABLE_WINDOW_ANIMATION, true);
        return capabilities;
    }
}
