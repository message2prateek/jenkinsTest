package com.chaapu.webdriver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


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

    private static void getTimeSoFarInSeconds() {
        long timeNow = System.currentTimeMillis() / 1000;

        String secondsTaken = String.valueOf(timeNow - startTimeInSeconds);
        LOG.info("Time taken (secs) for specification execution so far: " + secondsTaken);
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
        LOG.info("Gecko driver Directory = " + System.getProperty("user.dir") + "/bin/geckodriver");
        System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/bin/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary("/usr/lib/firefox/firefox");
        firefoxOptions.setCapability("marionette", true);
        driver = new FirefoxDriver(firefoxOptions);
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
