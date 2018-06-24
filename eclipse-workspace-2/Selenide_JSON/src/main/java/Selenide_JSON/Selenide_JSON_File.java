package Selenide_JSON;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.codeborne.selenide.WebDriverRunner;

import org.openqa.selenium.By;


public class Selenide_JSON_File {
	
	String url,searchWord, link;
	JSONParser parser = new JSONParser();
@BeforeTest
public void setUp() throws FileNotFoundException, IOException, ParseException
{
	Object obj = parser.parse(new FileReader("c:\\sel.json"));

    JSONObject jsonObject = (JSONObject) obj;
    url = (String) jsonObject.get("URL");
    link = (String) jsonObject.get("linkSearch");
    
    searchWord = (String) jsonObject.get("SearchWord");
	System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	WebDriverRunner.setWebDriver(driver);
	open(url);
}

@Test 
public void test()
{
	$(By.name("q")).setValue(searchWord);
	$(By.name("btnK")).click();
	
	$(By.linkText(link)).click();
	
	Assert.assertEquals(link, "Katalon Studio: Best automated testing tool for web, mobile, API");
	
}
@AfterTest
public void tearDown()
{
	 close();
}

}
