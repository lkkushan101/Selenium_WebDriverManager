package SeleniumAngular;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Selenium_Angular {
	
	WebDriver driver;
	
@BeforeTest
	public void setup()
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		
		 driver.get("https://angularjs.org/"); // sample url	
         	
	}

@Test

	public void testSearch() throws InterruptedException
	{
	    WebDriverWait wait=new WebDriverWait(driver, 20);  	
	
		
		WebElement namesInput;
		namesInput= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//input[@ng-model='yourName']")));
		namesInput.sendKeys("Kushan");
		
		WebElement todo_item= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//input[@ng-model='todoList.todoText']")));
		todo_item.sendKeys("Kushan Amarasiri");
		
		WebElement button_add= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//input[@class='btn-primary']")));
		button_add.click();
		
		
		
		String name = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div[2]/div/ul/li[3]/label/span")).getText();
		
		assertEquals(name,"Kushan Amarasiri" );
		
		
		WebElement search_input= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//input[@ng-model='projectList.search']")));
		search_input.sendKeys("AngularJS");
		
		
		if (driver.findElement(By.linkText("AngularJS")).isDisplayed())
		{
			System.out.println("Item found");
		}
		
				
		
		
		
	}

@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
