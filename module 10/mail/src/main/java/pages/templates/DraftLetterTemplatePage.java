package pages.templates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CommonPage;
import utils.WaitUtils;

import java.util.ArrayList;
import java.util.List;

public class DraftLetterTemplatePage extends BasePage {

    List<String> letterAttributes;

    private static final String MAIL_RECIPIENT_FIELD = "//input[@class = 'container--H9L5q size_s--3_M-_' and @tabindex = '100']";
    private static final String SUBJECT_FIELD = "//input[@name='Subject']";
    private static final String CLOSE_BUTTON = "//button[@data-promo-id= 'collapse']";
    private static final String CLOSE_CONFIRMATION_BUTTON = "//button[@title = 'Закрыть']";
    private static final String MAIL_BODY_FIELD = "//*[@role = 'textbox']";
    private static final String SEND_LETTER_BUTTON = "//span[@data-title-shortcut = 'Ctrl+Enter']";


    @FindBy(xpath = MAIL_RECIPIENT_FIELD)
    private WebElement mailRecipientField;

    @FindBy(xpath = SUBJECT_FIELD)
    private WebElement subjectField;

    @FindBy(xpath = MAIL_BODY_FIELD)
    private WebElement mailBodyField;

    @FindBy(xpath = CLOSE_BUTTON)
    private WebElement closeButton;

    @FindBy(xpath = SEND_LETTER_BUTTON)
    private WebElement sendLetterButton;

    @FindBy(xpath = CLOSE_CONFIRMATION_BUTTON)
    private WebElement closePopup;


    public DraftLetterTemplatePage fillInLetterFields() {
        fillInLetterSubject("avsc");
        fillInLetterRecipient("denqa.test@yandex.ru");
        fillInLetterBody("anything");
        logger.info("Letter fields were filled in");
        return this;
    }

    public CommonPage closeLetterWithoutSaving() {
        WaitUtils.waitUntilVisibilityOfElement(driver,closeButton);
        closeButton.click();
        return new CommonPage();

    }

    public CommonPage sendLetter()  {

       WaitUtils.waitUntilVisibilityOfElement (driver,sendLetterButton);
        sendLetterButton.click();
        return new CommonPage();
    }

    public DraftLetterTemplatePage closePopup ()  {

        WaitUtils.waitUntilVisibilityOfElement (driver,closePopup);
        closePopup.click();
        return this;
    }

    public DraftLetterTemplatePage fillInLetterWithDataFromTest(String subject, String recipient, String body) {
        fillInLetterSubject(subject);
        fillInLetterRecipient(recipient);
        fillInLetterBody(body);
        logger.info("Letter fields were filled in");
        return this;
    }

    public String findLetterAttributes() {
        letterAttributes = new ArrayList<>();
        String actualSubjectValue = subjectField.getAttribute("value");
        letterAttributes.add(actualSubjectValue);

//        String actualBodyValue = mailBodyField.getText();
//        letterAttributes.add(actualBodyValue);
        return letterAttributes.toString();
    }

    public void fillInLetterRecipient(String letterRecipient) {
        mailRecipientField.click();
        mailRecipientField.sendKeys(letterRecipient);
    }

    public void fillInLetterSubject(String letterSubject) {
        waitForPageToBeLoaded();
        subjectField.click();
        subjectField.sendKeys(letterSubject);
    }

    public void fillInLetterBody(String letterBody) {
        mailBodyField.click();
        mailBodyField.sendKeys(letterBody);
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(SEND_LETTER_BUTTON));
    }
}
