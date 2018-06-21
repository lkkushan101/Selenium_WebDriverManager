package NGWebPkg;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;


public class NGWebBasics {
	
	static WebDriver driver;
	static NgWebDriver ngdriver;
	 
	
@BeforeTest
	public void setup()
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://hello-angularjs.appspot.com/sorttablecolumn");
		
		ngdriver = new NgWebDriver((JavascriptExecutor) driver);
	}

@Test

	public void testSearch()
	{
		driver.findElement(ByAngular.model("name")).sendKeys("Kushan Amarasiri");
		driver.findElement(ByAngular.model("employees")).sendKeys("30");
		driver.findElement(ByAngular.model("headoffice")).sendKeys("Colombo");
		driver.findElement(ByAngular.buttonText("Submit")).click();
		
		
		  String txt = driver.findElement(ByAngular.repeater("company in companies").row(4).column("name")).getText();
		  System.out.println(txt + " Added.");
		
	}

@AfterTest
	public void tearDown()
	{
	  driver.close();
	  driver.quit();
	}
}
