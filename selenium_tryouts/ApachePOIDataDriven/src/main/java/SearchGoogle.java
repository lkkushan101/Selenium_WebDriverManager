
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SearchGoogle {
	
	WebDriver driver;
	ExcelRead excel = new ExcelRead();
@BeforeTest
	public void setup() throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(excel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1"));
	}

@Test

	public void testSearch() throws IOException
	{
		driver.findElement(By.id("lst-ib")).sendKeys(excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"));
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.linkText(excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"))).click();
		
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
