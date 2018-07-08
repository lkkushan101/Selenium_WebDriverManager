package SeleniumBasics;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class AlertHandle {
	
	static WebDriver driver;
	
	 
	
@BeforeTest
	public void setup()
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		
	}

@Test

	public void testSearch()
	{
	  driver.findElement(By.name("cusid")).sendKeys("53920");					
      driver.findElement(By.name("submit")).submit();	
      Alert alert = driver.switchTo().alert();
      String alertMessage= driver.switchTo().alert().getText();	
      System.out.println(alertMessage);	
      alert.accept();	
	}

@AfterTest
	public void tearDown()
	{
	  driver.close();
	  driver.quit();
	}
}
