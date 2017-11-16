package com.chaapu.munnu.web;

import com.chaapu.munnu.webdriver.WebDriverFixture;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;


@RunWith(ConcordionRunner.class)
public class WebTest extends WebDriverFixture {

    public void navigateToPage() {
        getWebDriver().get("localhost:8081/login");
    }

    public boolean isHeadingDisplayed() {
        WebElement heading = new WebDriverWait(getWebDriver(), 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("heading")));

        return heading
                .getText()
                .equals("This below is a list of important stuff");
    }

    public boolean areItemsDisplayed() {
        return getWebDriver().findElements(By.tagName("li")).size() == 3;
    }

    public boolean isHomePageDisplayed() {
        new WebDriverWait(getWebDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.name("userName")));
        return getWebDriver().findElement(By.name("message")).isDisplayed();
    }

    public void loginUsingValidCredentials() {
        login("chaapu", "munnu");
    }

    public void loginUsingInvalidCredentials() {
        login("bla", "bla");
    }

    private void login(String userName, String password) {
        getWebDriver().findElement(By.name("userName")).sendKeys(userName);
        getWebDriver().findElement(By.name("password")).sendKeys(password);
        getWebDriver().findElement(By.name("submit")).click();

    }

    public boolean isErrorMessageDisplayed() {
        return getWebDriver().findElement(By.name("error")).isDisplayed();
    }
}
