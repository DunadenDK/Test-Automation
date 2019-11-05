package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class ScenarioHooks {

    protected WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://mail.ru/";

    @Before
    public void browserSetup() {
        setUpDriver();
        maximizeBrowser();
        setUpTimeout(driver);
        goToLoginPage();
    }

    void goToLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    void setUpDriver() {
        driver = DriverSingleton.getDriver();
    }

    void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    public static void setUpTimeout(WebDriver driver) {
        int timeout = Integer.valueOf(System.getProperty("Timeout"));
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    @After
    public void browserClose() {
        DriverSingleton.closeDriver();
    }
}
