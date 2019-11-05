package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverSingleton;
import models.Letter;
import org.junit.Assert;
import pages.CommonPage;
import pages.authorization.HomePage;
import pages.templates.DraftLetterTemplatePage;
import service.LetterFieldsFiller;

import java.util.List;

public class LoginSteps {
   // protected Letter testLetter = LetterFieldsFiller.withDataFromProperty();
    DraftLetterTemplatePage draftLetterTemplate;
    CommonPage commonPage;

    @Given("User is logged in into mailbox account$")
    public void userIsLoggedIn() {
        Assert.assertTrue(DriverSingleton.getDriver().getCurrentUrl().contains("https://mail.ru"));
    }

    @When("I do login into my mailbox account$")
    public void loginToMailbox() {
        new HomePage().userEnterCredentials();
    }

//    @Then("^I'm logged into it$")
//    public void checkUserIsLoggedIntoCorrectMailbox() {
//        String actualMailboxName = new CommonPage().findTheNameOfMailboxYouAreLoggedInto();
//        Assert.assertEquals(actualMailboxName, "denqa.test@mail.ru");
//    }

    @And("^I create new letter$")
    public void userCreatesLetter() {
     draftLetterTemplate = new CommonPage().openTemplateForWritingNewLetter() .fillInLetterFields();
    }
    @And("^I close letter without saving it$")
    public void userClosesLetterWithoutSaving() {
        commonPage = draftLetterTemplate.closeLetterWithoutSaving();
    }


    @Then("^I find this letter in a draft folder$")
    public void userChecksThatLetterIsSavedAsDraft() throws InterruptedException {
        String actualDraftLetterFields =
                commonPage.goToDraftsPage()
                        .openDraftLetter()
                        .findLetterAttributes();
        Assert.assertEquals(actualDraftLetterFields, "[avsc]");
    }
}
