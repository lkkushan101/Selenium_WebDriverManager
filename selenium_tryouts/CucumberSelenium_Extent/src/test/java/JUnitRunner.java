
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	

	@RunWith(Cucumber.class)
	@CucumberOptions(
			plugin = {"pretty","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
			glue = {"stepdefs"},//Your step definitions package.
			features = {"C:\\Users\\kam\\selenium_tryouts\\CucumberSelenium\\src\\test\\java\\GoogleSearch.feature"},
		
		        monochrome = true)
	
	public class JUnitRunner {
		
		 @AfterClass
		    public static void writeExtentReport() {
		        Reporter.loadXMLConfig(new File("config/report.xml"));
		 }
	}
