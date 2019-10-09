package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.templates.DraftLetterTemplatePage;
import pages.authorization.LoginPage;
import pages.items.DraftsPage;
import pages.items.SentMailPage;
import utils.WaitUtils;

public class CommonPage extends BasePage {




    @FindBy (xpath = "//*[@id = 'PH_user-email']" )
    private WebElement mailboxIndication;

    @FindBy(xpath = "//*[@id = 'PH_user-email']")
    private WebElement accountSettings;

    @FindBy(xpath = "//*[@title = 'выход']")
    private WebElement exitButton;

    @FindBy(xpath = "//span[@class = 'compose-button__wrapper']")
    private WebElement writeNewLetterButton;

    @FindBy(xpath = "//*[@href = '/drafts/']")
    private WebElement draftsFolder;

    @FindBy(xpath = "//*[@href = '/sent/']")
    private WebElement sentMailFolder;


    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public String findTheNameOfMailboxYouAreLoggedInto() {
        String mailboxName = mailboxIndication.getText();
        return mailboxName;
    }

    public DraftLetterTemplatePage openTemplateForWritingNewLetter() {
        writeNewLetterButton.click();
        return new DraftLetterTemplatePage(driver);
    }

    public DraftsPage goToDraftsPage() {
        draftsFolder.click();
        return new DraftsPage(driver);
    }

    public SentMailPage goToSentMailFolder() {
        sentMailFolder.click();
        resfreshCurrentPage();
        return new SentMailPage(driver);
    }

    public LoginPage exitFromCurrentMailbox() {
        Actions action = new Actions(driver);
        waitForPageToBeLoaded();
        action.click(mailboxIndication).perform();
        waitForElementToBeLoaded(accountSettings);
        action.click(accountSettings).perform();
      //  waitForElementToBeLoaded(currentAccountButton);
       // action.click(currentAccountButton).perform();
        waitForElementToBeLoaded(exitButton);
        action.click(exitButton).build().perform();

        return new LoginPage(driver);
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath("//*[@id = 'PH_user-email']"));
    }

    @Override
    protected void waitForElementToBeLoaded(WebElement element) {
        WaitUtils.waitUntilVisibilityOfElement(driver, element);
    }
}
/*
public class CommonPage extends BasePage {

    @FindBy (xpath = "//*[@id = 'PH_user-email']" )
    private WebElement mailboxIndication;

    @FindBy(xpath = "//*[@id = 'PH_user-email']")
    private WebElement accountSettings;

    @FindBy(xpath = "//*[@title = 'выход']")
    private WebElement exitButton;

    @FindBy(xpath = "//span[@class = 'compose-button__wrapper']")
    private WebElement writeNewLetterButton;

    @FindBy(xpath = "//*[@href = '/drafts/']")
    private WebElement draftsFolder;

    @FindBy(xpath = "//*[@href = '/sent/']")
    private WebElement sentMailFolder;


    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public String getTheNameOfMailboxYouAreLoggedInto() {
        String mailboxName = mailboxIndication.getText();
        return mailboxName;
    }


}
*/