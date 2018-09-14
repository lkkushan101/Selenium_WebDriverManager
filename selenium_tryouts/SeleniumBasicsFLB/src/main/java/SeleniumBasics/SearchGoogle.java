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
import java.util.Collection;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.googlecode.fightinglayoutbugs.FightingLayoutBugs;
import com.googlecode.fightinglayoutbugs.LayoutBug;
import com.googlecode.fightinglayoutbugs.WebPage;

public class SearchGoogle {
	 FightingLayoutBugs flb;
	WebDriver driver;
	String url,searchWord, linkText;
	JSONParser parser = new JSONParser();
@BeforeTest
	public void setup() throws FileNotFoundException, IOException, ParseException 
	{
	  Object obj = parser.parse(new FileReader("c:\\sel.json"));

      JSONObject jsonObject = (JSONObject) obj;
      url = (String) jsonObject.get("URL");
      searchWord = (String) jsonObject.get("SearchWord");
	  linkText = (String) jsonObject.get("linkSearch");
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

@Test

	public void testSearch()
	{
        flb = new FightingLayoutBugs();
		driver.findElement(By.id("lst-ib")).sendKeys(searchWord);
		driver.findElement(By.id("hplogo")).click();
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.linkText(linkText)).click();
		
		String webTitle = driver.getTitle();
		
		Assert.assertEquals(webTitle, linkText);
		 WebPage webPage = new WebPage(driver);
		FightingLayoutBugs flb = new FightingLayoutBugs();
        final Collection<LayoutBug> layoutBugs = flb.findLayoutBugsIn(webPage);
        System.out.println("Found " + layoutBugs.size() + " layout bug(s).");
        for (LayoutBug bug : layoutBugs) {
            System.out.println(bug);
        }
	}

@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
