package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.util.concurrent.TimeUnit;

public class WaitUtils {

    public static void waitUntilVisibilityOfElementLocatedBy(WebDriver driver, By by) {
        Wait wait = new FluentWait(driver)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(UnhandledAlertException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public static void waitUntilVisibilityOfElement(WebDriver driver, WebElement webElement) {
        Wait wait = new FluentWait(driver)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(UnhandledAlertException.class);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitUntilClickableOfElement(WebDriver driver, WebElement webElement) {
        Wait wait = new FluentWait(driver)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(UnhandledAlertException.class);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
