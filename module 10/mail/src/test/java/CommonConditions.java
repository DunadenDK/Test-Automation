import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;



public class CommonConditions {
    protected final Logger logger = LogManager.getRootLogger();
    WebDriver driver;

    @BeforeClass()
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.navigate().to("https://mail.ru");
        logger.info("Login page was opened");
    }

   @AfterClass()
   public void terminateBrowser() {
        DriverSingleton.closeDriver();
    }
}
