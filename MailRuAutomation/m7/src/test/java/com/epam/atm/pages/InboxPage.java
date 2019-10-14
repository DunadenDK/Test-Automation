package com.epam.atm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InboxPage extends AbstractPage {

    private static final By COMPOSE_BUTTON_LOCATOR = By.xpath("./descendant::span[contains(text(), 'Написать письмо')][1]");
    private static final By DRAFTS_ITEM_LOCATOR = By.xpath("//span[@class='b-datalist__item__subj__snippet']");
    private static final By NO_DRAFTS_MESSAGE_LOCATOR = By.cssSelector("div[class='b-datalist__empty__block']");
    private static final By SENT_BUTTON_LOCATOR = By.xpath("./descendant::span[contains(text(), 'Отправленные')][1]");
    private static final By SENT_ITEM_LOCATOR = By.xpath("//div[@class='b-datalist__item__panel']//div[@class='b-datalist__item__subj']");
    private static final By LOGOUT_LOCATOR = By.id("PH_logoutLink");

    public InboxPage(WebDriver driver){
        super(driver);
    }

    public ComposePage clickComposeButton(){
        (new WebDriverWait(driver, 30))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(COMPOSE_BUTTON_LOCATOR))
                .click();
        return new ComposePage(driver);
    }

    public ComposePage clickDraftsItem(){
        waitForElementClickable(DRAFTS_ITEM_LOCATOR);
        driver.findElement(DRAFTS_ITEM_LOCATOR).click();
        return new ComposePage(driver);
    }

    public boolean isNoDraftsMessageVisible(){
        //Utils.threadSleep();
        waitForElementVisisble(NO_DRAFTS_MESSAGE_LOCATOR);
        return driver.findElement(NO_DRAFTS_MESSAGE_LOCATOR).isDisplayed();
    }

    public InboxPage clickSentButton(){
        waitForElementVisisble(SENT_BUTTON_LOCATOR);
        driver.findElement(SENT_BUTTON_LOCATOR).click();
        return this;
    }

    public List<WebElement> getSentItems(){
        waitForElementPresence(SENT_ITEM_LOCATOR);
        List<WebElement> sentItems = driver.findElements(SENT_ITEM_LOCATOR);
        return sentItems;
    }

    public HomePage logOut(){
        waitForElementClickable(LOGOUT_LOCATOR);
        driver.findElement(LOGOUT_LOCATOR).click();
        return new HomePage(driver);
    }
}
