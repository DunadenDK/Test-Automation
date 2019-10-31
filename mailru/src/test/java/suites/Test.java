package suites;



import cucumber.api.CucumberOptions;
        import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report/test", "json:target/cucumber.json"},
        tags = {"@TEST"},
        glue = {"src.test.java.features"},
        features = "src\\test\\java\\features\\LoginToMailbox.feature")
public class Test extends AbstractTestNGCucumberTests {

}