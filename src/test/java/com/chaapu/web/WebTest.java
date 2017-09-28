package com.chaapu.web;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@RunWith(ConcordionRunner.class)
public class WebTest extends WebDriverFixture {
    public void navigateToPage() {
        getWebDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/java/com/chaapu/web/HelloWorld.html");
    }

    public boolean isHeadingDisplayed() {
        WebElement heading = new WebDriverWait(getWebDriver(), 2).until(ExpectedConditions.visibilityOfElementLocated(By.id("heading")));
        return heading
                .getText()
                .equals("This below is a list of important stuff");
    }

    public boolean areItemsDisplayed() {
        return getWebDriver().findElements(By.tagName("li")).size() == 3;
    }
}
