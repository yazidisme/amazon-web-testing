package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseClass {

    public WebDriver webDriver;
    public WebDriverWait webDriverWait;

    public BaseClass(WebDriver webDriver, WebDriverWait webDriverWait) {

        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    protected void waitUntilElementIsVisible(WebElement webElement) {

        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitUntilListElementIsVisible(List<WebElement> webElements) {

        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    protected void waitUntilElementIsClickable(WebElement webElement) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
