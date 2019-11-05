package suites;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        glue = {"steps"},
        features = "src\\test\\resources\\features\\LogInToMailbox.feature")
public class SmokeTestSuite  {
}
