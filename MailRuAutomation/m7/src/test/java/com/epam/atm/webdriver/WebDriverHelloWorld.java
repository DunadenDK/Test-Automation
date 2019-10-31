package com.epam.atm.webdriver;

import com.epam.atm.data.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class WebDriverHelloWorld {
    private WebDriver webDriver;
    private final String toText = "denqa.test@gmail.com";
    private String subjectText;
    private final String bodyText = "Hi, I'm testing auto tests";
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    String loginData = TestData.getLoginNameValue();
    String domainData = TestData.getDomainValue();
    String passwordData = TestData.getPasswordValue();


    @BeforeClass(description = "Browser start")
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        webDriver = new ChromeDriver(chromeOptions);
    }

    @BeforeMethod(description = "Open mail.ru")
    public void openWebSite() {
        webDriver.get("https://mail.ru/");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(description = "Close browser")
    public void closeBrowser() {
        webDriver.quit();
    }

    @Test
    public void emailFlowTest() throws InterruptedException {

        webDriver.manage().window().maximize();
        WebElement accountNameField = webDriver.findElement(By.cssSelector("input[name='login']"));
        Select domainNameField = new Select(webDriver.findElement(By.cssSelector("select[id='mailbox:domain']")));
        WebElement passwordTextField = webDriver.findElement(By.cssSelector("input[id='mailbox:password']"));
        WebElement loginButton = webDriver.findElement(By.xpath( "//input[@class='o-control']"));

        accountNameField.sendKeys(loginData);
        loginButton.click();
        passwordTextField.sendKeys(passwordData);
        domainNameField.selectByVisibleText(domainData);
        loginButton.click();

        WebElement composeEmailButton = (new WebDriverWait(webDriver, 30))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("./descendant::span[contains(text(), 'Написать письмо')][1]")));

        composeEmailButton.click();

        //вбиваем кому в поле адресата
        
        WebElement toTextField = webDriver.findElement(By.xpath("//input[@class = 'container--H9L5q size_s--3_M-_' and @tabindex = '100']"));
        
        toTextField.sendKeys(toText);
        
        //вбиваем тему в поле subject
        
        WebElement subjectTextField = webDriver.findElement(By.xpath("//input[@name='Subject']"));
        
        subjectTextField.sendKeys(generateRandomString(12));
        
        //вбиваем контент в поле письма
        
        WebElement bodyTextArea = webDriver.findElement(By.xpath("//*[@role = 'textbox']"));
        
        bodyTextArea.sendKeys(bodyText);
       
        webDriver.switchTo().defaultContent();
        
        Thread.sleep(2000);
//сохраняем драфтовое письмо в папку        
        WebElement saveDraft = webDriver.findElement(By.xpath("//button[@title = 'Свернуть']"));
        
        saveDraft.click();
        
        Thread.sleep(2000);
 //открываем список с драфтовыми письмами       
        WebElement draftsButton = webDriver.findElement(By.xpath("//*[@href = '/drafts/']"));
        
        draftsButton.click();
//открываем письмо из драфта
        WebElement draftEmailItem = new WebDriverWait(webDriver, 10)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='llc__content']")));
        draftEmailItem.click();
//отправляем письмо из драфта
        WebElement sendButton = webDriver.findElement(By.xpath("//span[contains(text(), 'Отправить')]"));
        sendButton.click();

        WebElement logOffButton = webDriver.findElement(By.xpath("//*[@title = 'выход']"));
        logOffButton.click();
    }


    private String generateRandomString(int count){
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return subjectText = builder.toString();
    }

}
