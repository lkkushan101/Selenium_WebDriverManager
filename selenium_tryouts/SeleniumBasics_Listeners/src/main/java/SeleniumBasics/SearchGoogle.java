package SeleniumBasics;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(SeleniumBasics.ListenerTest.class)	
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


}
