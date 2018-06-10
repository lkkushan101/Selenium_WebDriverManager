package SeleniumBasics;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class SearchGoogle {
	
	WebDriver driver;
	String url,searchWord;
@BeforeTest
	public void setup() throws SAXException, IOException, ParserConfigurationException
	{
		File fXmlFile = new File("C:\\data.XML");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		
		
		 url = doc.getElementsByTagName("url").item(0).getTextContent();
	     searchWord = doc.getElementsByTagName("search_word").item(0).getTextContent();
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
