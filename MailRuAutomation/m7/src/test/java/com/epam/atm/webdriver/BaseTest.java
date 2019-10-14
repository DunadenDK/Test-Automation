package com.epam.atm.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;
    public static final String URL = "https://mail.ru/";
    public static final String ACCOUNT_NAME = "cfoxtrot";
    public static final String DOMAIN_NAME = "@inbox.ru";
    public static final String PASSWORD = "n5pYZu5dmeqHVzp";

    @BeforeClass(description = "Browser start")
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }

    @BeforeMethod(description = "Open mail.ru")
    public void openWebSite() {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    @AfterMethod(description = "Close browser")
//    public void closeBrowser() {
//        driver.quit();
//    }
}
