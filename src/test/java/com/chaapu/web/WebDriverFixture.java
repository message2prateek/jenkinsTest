package com.chaapu.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;


public class WebDriverFixture {
    private static final Log LOG = LogFactory.getFactory().getInstance(WebDriverFixture.class);
    private static WebDriver driver;

    private static long startTimeInSeconds;

    public WebDriverFixture() {
        LOG.info("Running tests (" + this.getClass().getSimpleName() + ")");
    }

    private static void signalStartExecution() {
        startTimeInSeconds = System.currentTimeMillis() / 1000;
    }

    private static String getTimeSoFarInSeconds() {
        long timeNow = System.currentTimeMillis() / 1000;

        String secondsTaken = String.valueOf(timeNow - startTimeInSeconds);
        LOG.info("Time taken (secs) for specification execution so far: " + secondsTaken);
        return secondsTaken;
    }

    protected static WebDriver getWebDriver() {
        return driver;
    }

    @BeforeClass
    public static void startTimer() {
        signalStartExecution();
    }

    @Before
    public void setup() {
        System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/bin/geckodriver");
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public static void stopTimer() {
        getTimeSoFarInSeconds();
    }
}
