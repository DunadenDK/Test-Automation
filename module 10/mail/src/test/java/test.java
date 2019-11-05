

import org.junit.Test;
import pages.authorization.HomePage;
import pages.templates.DraftLetterTemplatePage;


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

    //   Thread.sleep(10000);
        new DraftLetterTemplatePage()
                .closePopup();
              //  .exitFromCurrentMailbox();

        }

    }





