package pages.authorization;

import models.Mailbox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CommonPage;
import utils.ElementUtils;
import utils.WaitUtils;

public class LoginPage extends BasePage {

    private static final String LOGIN_INPUT = "input[name='Login']";
    private static final String PASSWORD_INPUT = "input[id='mailbox:password']";
    private static final String PROCEED_BUTTON =  "//button[@type='submit']";

    @FindBy(css = LOGIN_INPUT)
    private WebElement loginField;

    @FindBy(css = PASSWORD_INPUT)
    private WebElement passwordField;

    @FindBy(xpath = PROCEED_BUTTON)
    private WebElement proceedButton;

/*
    public CommonPage enterCredentials(Mailbox mailbox) {
        userEntersLoginName(mailbox.getMailboxName());
        userEntersPasswordValue(mailbox.getMailboxPassword());
        logger.info("Login was performed");
        return new CommonPage();
    }
*//*
    public LoginPage userEnterCredentials (){
        driver.findElement(By.cssSelector("input[name='login']")).sendKeys("denqa.test");
        driver.findElement(By.xpath("//input[@class='o-control']")).click();
        driver.findElement(By.cssSelector("input[id='mailbox:password']")).sendKeys("S2501552s");
        driver.findElement(By.xpath("//input[@class='o-control']")).click();
        return this;
    }
/*
    public LoginPage userEntersLoginName(String mailboxName) {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(LOGIN_INPUT));
        ElementUtils.highlightElement(driver, By.xpath(LOGIN_INPUT));
        ElementUtils.clickOnElementAndTypeData(driver, loginField, mailboxName);
        ElementUtils.clickElementJs(driver, proceedButton);
        return this;
    }

    public CommonPage userEntersPasswordValue(String mailboxPassword) {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(PASSWORD_INPUT));
        ElementUtils.highlightElement(driver, By.xpath(PASSWORD_INPUT));
        ElementUtils.clickOnElementAndTypeData(driver, passwordField, mailboxPassword);
        ElementUtils.clickElementJs(driver, proceedButton);
        return new CommonPage();
    }

*/

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(PROCEED_BUTTON));
    }
}