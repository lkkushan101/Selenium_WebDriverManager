package SeleniumBasics;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class Frames {
	
	static WebDriver driver;
	
	 
	
@BeforeTest
	public void setup()
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://toolsqa.com/iframe-practice-page/");
		
		
	}

@Test

	public void testSearch() throws InterruptedException
	{
	  System.out.println("Switching Frame 1");
	  driver.switchTo().frame("iframe1");
	  driver.findElement(By.name("firstname")).sendKeys("Kushan");					
      driver.findElement(By.name("lastname")).sendKeys("Amarasiri");		
      Thread.sleep(5000);
      
      System.out.println("Switching Parent Frame");
      driver.switchTo().parentFrame();
      
      System.out.println("Switching Frame 2");
      driver.switchTo().frame("iframe2");
      driver.findElement(By.xpath("//img[@class='alignnone size-medium wp-image-225']")).click();
      
	}

@AfterTest
	public void tearDown()
	{
	  driver.close();
	  driver.quit();
	}
}
