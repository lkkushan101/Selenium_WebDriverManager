package CalculatorPkg;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;
import org.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class CalculatorClass {
	    private static WindowsDriver NotepadSession = null;
	    private static WebElement CalculatorResult = null;

	    private static WindowsDriver CalculatorSession = null;
	    private static WebElement CalculatorResult1 = null;

    protected String _GetCalculatorResultText1()
    {
        // trim extra text and whitespace off of the display value
        return CalculatorResult1.getText().replace("Display is", "").trim();
    }
    protected String _GetCalculatorResultText()
    {
        // trim extra text and whitespace off of the display value
        return CalculatorResult.getText().replace("Display is", "").trim();
    }
	
	
@Test
public void testCalc() throws MalformedURLException
{

	
	DesiredCapabilities appCapabilities = new DesiredCapabilities();
	appCapabilities.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
	//appCapabilities.setCapability("appArguments", "MyTestFile.txt");
	//appCapabilities.setCapability("appWorkingDir", "C:\\");
	NotepadSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), appCapabilities);

	// Use the session to control the app
	NotepadSession.findElementByClassName("Edit").click();
	NotepadSession.findElementByClassName("Edit").sendKeys("This is some text");
	
	
     
}

@Test
public void testCalc2() throws MalformedURLException

{
	 DesiredCapabilities capabilities = new DesiredCapabilities();
     capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
     CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
     CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

     CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults");
     Assert.assertNotNull(CalculatorResult);
	  CalculatorSession.findElementByName("Two").click();
      CalculatorSession.findElementByName("Plus").click();
      CalculatorSession.findElementByName("Three").click();
      CalculatorSession.findElementByName("Equals").click();
      Assert.assertEquals("5", _GetCalculatorResultText());

}


}
