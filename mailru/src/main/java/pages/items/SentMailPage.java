package pages.items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.templates.SentLetterTemplatePage;
import utils.WaitUtils;

public class SentMailPage extends BasePage {

    private static final String SENT_LETTER = "//*[@class='llc__content']";

    @FindBy(xpath = SENT_LETTER)
    private WebElement sentLetter;


    public SentLetterTemplatePage openSentLetter() {
        refreshCurrentPage();
        waitForPageToBeLoaded();
        sentLetter.click();
        logger.info("Letter was sent");
        return new SentLetterTemplatePage();
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(SENT_LETTER));
    }
}
