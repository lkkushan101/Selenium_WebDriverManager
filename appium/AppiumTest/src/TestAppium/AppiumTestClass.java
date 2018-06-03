package TestAppium;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

public class AppiumTestClass {
	WebDriver driver;
	@BeforeClass
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName","emulator-5554");
		capabilities.setCapability("platformName","Android");
	 
	   
	   capabilities.setCapability("appPackage", "com.android.calculator2");
	// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	   
	   @Test
	   public void testCal() throws Exception {
	      //locate the Text on the calculator by using By.name()
	     driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
	     
	     driver.findElement(By.id("com.android.calculator2:id/op_add")).click();

	     driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
	     
	     driver.findElement(By.id("com.android.calculator2:id/eq")).click();
	      //locate the edit box of the calculator by using By.tagName()
	      String results=driver.findElement(By.id("com.android.calculator2:id/result")).getText();
	   	//Check the calculated value on the edit box
	     assert results.equals("18"):"Actual value is : "+results+" did not match with expected value: 18";

	   }
	}


