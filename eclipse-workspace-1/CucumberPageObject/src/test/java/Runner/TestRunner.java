package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = {"C:\\Users\\kam\\eclipse-workspace-1\\CucumberPageObject\\src\\test\\java\\features\\LoginScenario.feature"},glue = "stepdefs")

public class TestRunner extends AbstractTestNGCucumberTests {

}
