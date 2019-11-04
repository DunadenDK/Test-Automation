
import driver.DriverSingleton;
import driver.decorator.CustomDriverDecorator;
import models.Letter;
import models.Mailbox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.authorization.HomePage;
import pages.authorization.LoginPage;
import service.LetterFieldsFiller;
import service.MailboxCreator;


public class test extends CommonConditions{



 //   protected Letter testLetter = LetterFieldsFiller.withDataFromProperty();

    @Test()

        public void loginToMailbox() throws InterruptedException {

            new HomePage()
                    .userEnterCredentials()
                    .openTemplateForWritingNewLetter()
                    .fillInLetterFields()
                    .closeLetterWithoutSaving()
                    .goToDraftsPage()
                    .openDraftLetter()
                    .sendLetter()
                    .goToSentMailFolder()
                    .openSentLetter()
                    .getLetterSubject();
            new CommonPage()
                    .exitFromCurrentMailbox()
                    ;

        }

    }





