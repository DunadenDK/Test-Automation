package data;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TestData {
    private static final String LOGIN_NAME_VALUE = "denqa.test";
    private static final String PASSWORD_VALUE = "S2501552s";

    private static final String EMAIL_RECIPIENT_VALUE = "denqa.test@gmail.com";
    private static final String EMAIL_SUBJECT_VALUE = "automation task";
    private static final String EMAIL_BODY_VALUE = "This is test task for webdriver module.";


    public static String getLoginNameValue() {
        return LOGIN_NAME_VALUE;
    }

    public static String getPasswordValue() {
        return PASSWORD_VALUE;
    }

    public static String getMailRecipientValue() { return EMAIL_RECIPIENT_VALUE; }

    public static String getMailSubjectValue() {
        return EMAIL_SUBJECT_VALUE;
    }

    public static String getMailBodyValue() {
        return EMAIL_BODY_VALUE;
    }
}
