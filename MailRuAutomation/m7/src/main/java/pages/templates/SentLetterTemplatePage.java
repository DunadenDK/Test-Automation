package pages.templates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.WaitUtils;

public class SentLetterTemplatePage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Отправить')]")
    private WebElement forwardButton;

    @FindBy(xpath = "//input[@class = 'container--H9L5q size_s--3_M-_' and @tabindex = '400']")
    private WebElement letterSubject;

    public SentLetterTemplatePage(WebDriver driver) {
        super(driver);
    }

    public String checkThatMailBodyIsCorrect() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath("//input[@class = 'container--H9L5q size_s--3_M-_' and @tabindex = '400']"));
        String actualLetterSubject = letterSubject.getText();
        return actualLetterSubject;
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath("//span[contains(text(), 'Отправить')]"));
    }

    @Override
    protected void waitForElementToBeLoaded(WebElement element) {

    }
}