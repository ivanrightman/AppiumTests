package com.learning.appium.utils;

import com.learning.appium.driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import static java.lang.String.format;

public class TestListener implements ITestListener {

    private static final Logger LOG = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("{} started", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("{} passed", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("{} failed", result.getName());
        takeScreenshot();
    }

    private void takeScreenshot() {
        File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(".//target/screenshots/$s.png", String.valueOf(LocalDateTime.now())));
        } catch (IOException e) {
            LOG.error("Failed to save screenshot: {}", e.getMessage());
        }
    }
}
