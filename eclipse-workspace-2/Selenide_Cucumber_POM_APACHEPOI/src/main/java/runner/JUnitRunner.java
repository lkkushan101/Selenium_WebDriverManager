package runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	

	@RunWith(Cucumber.class)
	@CucumberOptions(
			plugin = {"pretty"},
			glue = {"stepdefs"},//Your step definitions package.
			features = {"C:\\Users\\kam\\eclipse-workspace-2\\Selenide_Cucumber_POM\\src\\main\\java\\features\\Login.feature"})
	
	public class JUnitRunner {}
