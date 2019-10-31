package pages.authorization;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class HomePage extends BasePage {
    private static final String LOGIN_BUTTON_XPATH = "//a[contains(@id, 'PH_authLink')]";

    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private WebElement loginButton;


    public LoginPage proceedToLoginPage() {
        loginButton.click();
        logger.info("Login page was opened");
        return new LoginPage();
    }

    @Override
    protected void waitForPageToBeLoaded() {
    }
}