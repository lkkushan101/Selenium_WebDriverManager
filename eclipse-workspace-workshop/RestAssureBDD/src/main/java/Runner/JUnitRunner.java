package Runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	

	@RunWith(Cucumber.class)
	@CucumberOptions(
			plugin = {"pretty"},
			glue = {"stepdefs"},//Your step definitions package.
			features = {"C:/Users/kam/eclipse-workspace-workshop/RestAssureBDD/src/main/java/features/RESTAssurePost.feature"})
	
	public class JUnitRunner {}
