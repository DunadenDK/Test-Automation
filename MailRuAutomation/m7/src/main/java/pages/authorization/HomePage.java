package pages.authorization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id='PH_authLink']")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage proceedToLoginPage() {
        loginButton.click();
        return new LoginPage(driver);
    }

    @Override
    protected void waitForPageToBeLoaded() {
    }

    @Override
    protected void waitForElementToBeLoaded(WebElement element) {

    }
}