package SeleniumBasics;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SearchGoogle {
	
	//WebDriver driver;
	


@Test

	public void testSearch()
	{
	    WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.lk");
		
		
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
		
		String webTitle = driver.getTitle();
		
		Assert.assertEquals(webTitle, "Selenium - Web Browser Automation");
		driver.close();
		driver.quit();
	}

@Test

public void testSearch2()
{
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://www.google.lk");	

	driver.findElement(By.id("lst-ib")).sendKeys("Selenide");
	driver.findElement(By.name("btnK")).click();
	driver.findElement(By.linkText("Selenide: concise UI tests in Java")).click();
	
	String webTitle = driver.getTitle();
	
	Assert.assertEquals(webTitle, "Selenide: concise UI tests in Java");
	driver.close();
	driver.quit();
 }
}
