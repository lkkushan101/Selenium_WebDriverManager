package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.windows.WindowsDriver;

public class CalculatorDefs {
	  private static WindowsDriver CalculatorSession = null;
	  private static WebElement CalculatorResult = null;
	  
	  protected String _GetCalculatorResultText()
	    {
	        // trim extra text and whitespace off of the display value
	        return CalculatorResult.getText().replace("Display is", "").trim();
	    }
	@Given("^I have opened up calculator application$")
	public void i_have_opened_up_calculator_application() throws Exception {
	   
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
        Assert.assertNotNull(CalculatorResult);
	}

	@When("^I add two plus three$")
	public void i_add_two_plus_three() throws Exception {
		  CalculatorSession.findElementByName("Two").click();
	      CalculatorSession.findElementByName("Plus").click();
	      CalculatorSession.findElementByName("Three").click();
	      CalculatorSession.findElementByName("Equals").click();
	  
	}

	@Then("^I should answer as five$")
	public void i_should_answer_as_five() throws Exception {
		Assert.assertEquals("5", _GetCalculatorResultText());
	   
	}


}
