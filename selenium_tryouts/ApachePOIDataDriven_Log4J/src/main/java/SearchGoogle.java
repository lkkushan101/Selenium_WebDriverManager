
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;


public class SearchGoogle {
	
	WebDriver driver;
	ExcelRead excel = new ExcelRead();
    Logger log = Logger.getLogger("devpinoyLogger");
@BeforeTest
	public void setup() throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		log.debug("Opening the Chrome browser");
		driver.get(excel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1"));
		log.debug("Navigating to Google");
	}

@Test

	public void testSearch() throws IOException
	{
		driver.findElement(By.id("lst-ib")).sendKeys(excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"));
		driver.findElement(By.name("btnK")).click();
		log.debug("Searching a Selenium");
		driver.findElement(By.linkText(excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"))).click();
		log.debug("Navigating Selenium HQ");
		String webTitle = driver.getTitle();
		
		Assert.assertEquals(webTitle, excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"));
	}

@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
