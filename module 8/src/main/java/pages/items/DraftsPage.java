package pages.items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.templates.DraftLetterTemplatePage;
import utils.ElementActionsUtils;
import utils.WaitUtils;

public class DraftsPage extends BasePage {

    private static final String DRAFT_LETTER = "//div[@class='mail-MessageSnippet-Content']";

    @FindBy(xpath = DRAFT_LETTER)
    private WebElement draftLetter;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public DraftLetterTemplatePage openDraftLetter() {
        waitForPageToBeLoaded();
        ElementActionsUtils.clickOnElement(driver, draftLetter);
        return new DraftLetterTemplatePage(driver);
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(DRAFT_LETTER));
    }
}
