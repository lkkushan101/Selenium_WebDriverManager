package SeleniumBasics;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SearchGoogle {
	
	WebDriver driver;
	String url,searchWord;
	JSONParser parser = new JSONParser();
@BeforeTest
	public void setup() throws FileNotFoundException, IOException, ParseException 
	{
	  Object obj = parser.parse(new FileReader("c:\\sel.json"));

      JSONObject jsonObject = (JSONObject) obj;
      url = (String) jsonObject.get("URL");
      searchWord = (String) jsonObject.get("SearchWord");
		
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}

@Test

	public void testSearch()
	{
	   
		driver.findElement(By.id("lst-ib")).sendKeys(searchWord);
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.linkText("Katalon Studio: Best automated testing tool for web, mobile, API")).click();
		
		String webTitle = driver.getTitle();
		
		Assert.assertEquals(webTitle, "Katalon Studio: Best automated testing tool for web, mobile, API");
	}

@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
