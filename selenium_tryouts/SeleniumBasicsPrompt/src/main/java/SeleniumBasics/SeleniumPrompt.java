package SeleniumBasics;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumPrompt {
	
	WebDriver driver;
	
@BeforeTest
	public void setup()
	{
		
	System.setProperty("webdriver.chrome.driver","C:\\gekhodriver\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		
	}

@Test

	public void testSearch() throws InterruptedException
	{
	    

		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//body/button")).click();
		
		driver.switchTo().alert().sendKeys("kushan");
		Thread.sleep(10000);
		

		
		
		
		
		
	}

@AfterTest
public void tearDown()
{
	  driver.close();
	  driver.quit();
}
}
