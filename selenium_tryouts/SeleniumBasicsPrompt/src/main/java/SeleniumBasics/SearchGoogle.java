package SeleniumBasics;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SearchGoogle {
	
	//WebDriver driver;
	


@Test

	public void testSearch() throws InterruptedException
	{
	    WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\gekhodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//body/button")).click();
		
		driver.switchTo().alert().sendKeys("kushan");
		Thread.sleep(10000);
		
		driver.close();
		driver.quit();
		
		
		
		
		
	}


}
