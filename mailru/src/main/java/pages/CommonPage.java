package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/*import pages.templates.DraftLetterTemplatePage;
import pages.authorization.LoginPage;
import pages.items.DraftsPage;
import pages.items.SentMailPage;
import utils.ElementUtils;*/
import utils.WaitUtils;

public class CommonPage extends BasePage {

    private static final String MAILBOX_INDICATION = "//div[@class='mail-User-Name']";


    @FindBy(xpath = MAILBOX_INDICATION)
    private WebElement mailboxIndication;


    public String findTheNameOfMailboxYouAreLoggedInto() {
        return mailboxIndication.getText();
    }
    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(MAILBOX_INDICATION));
    }
}
