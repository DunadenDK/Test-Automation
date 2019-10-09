package pages.authorization;

import data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CommonPage;
import utils.WaitUtils;

public class LoginPage extends BasePage {

   // private static final String LOGIN_INPUT = "//input[@type='text' and @name='Login']";
   // private static final String PASSWORD_INPUT = "//input[@type='password' and @name='passwd']";
  //  private static final String PROCEED_BUTTON = "//button[@type='submit']";

    String loginData = TestData.getLoginNameValue();
    String passwordData = TestData.getPasswordValue();

    @FindBy(xpath = "//input[@id = 'mailbox:login")
    private WebElement loginField;

    @FindBy(xpath = "//button[@data-test-id = 'next-button']")
    private WebElement passwordInputButton;

    @FindBy(xpath = "//*[@placeholder='Пароль']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@data-test-id = 'submit-button']")
    private WebElement proceedButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public CommonPage enterCredentials() {
        userEntersLoginName();
        userEntersPasswordValue();
        return new CommonPage(driver);
    }






   public LoginPage userEntersLoginName() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.id("mailbox:login"));
        loginField.sendKeys(loginData);
        passwordInputButton.click();
        return this;
    }
/*

    public LoginPage userEntersLoginName() {
       // WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath("//h1[contains (text(), 'Войти в аккаунт')]"));
        loginField.clear();
        loginField.sendKeys(loginData);
        passwordInputButton.click();
        return this;
    }
*/
    public CommonPage userEntersPasswordValue() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath("//*[@placeholder='Пароль']"));
        passwordField.click();
        passwordField.sendKeys(passwordData);
        proceedButton.click();
        return new CommonPage(driver);
    }





    public boolean checkThatYouHaveLoggedOff() {
        return passwordField.isDisplayed();
    }

   @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath("//button[@data-test-id = 'submit-button']"));
    }
   /* @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, );
    }

*/
    @Override
    protected void waitForElementToBeLoaded(WebElement element) {

    }
}