import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class SetUpAndTearDown {

    protected WebDriver driver;

    private static final String LOGIN_PAGE_URL = "https://mail.yandex.by";
    private static final String GOOGLE_CHROME_DRIVER_PATH = ".//src/main/resources/chromedriver.exe";
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    @BeforeClass(alwaysRun = true)
    @Parameters({"os", "browser", "url", "node"})
    public void setUp(String os, String browser, String url, String node) throws MalformedURLException {
        RemoteDriverTest remoteDriverTest = new RemoteDriverTest(os, browser, url, node);
        driver = remoteDriverTest.getDriver();
    }

    @BeforeMethod
    public void browserSetup() {
        prepareChromeBrowser();
        maximizeBrowser();
        goToLoginPage();
    }

    void goToLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    void prepareChromeBrowser() {
        System.setProperty(CHROME_DRIVER_PROPERTY, GOOGLE_CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
    }

    void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void browserClose() {
        driver.quit();
    }
}
