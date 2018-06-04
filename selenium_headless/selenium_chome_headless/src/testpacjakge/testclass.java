package testpacjakge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

import static org.testng.Assert.assertEquals;

import java.lang.String;
public class testclass {
	
	
public static void main (String args[])
{
	System.setProperty("webdriver.chrome.driver", "C:\\chromedrv\\chromedriver.exe");
 
	ChromeOptions ch = new ChromeOptions();
	ch.addArguments("headless");
	ch.addArguments("window-size=1200x600");
	
	WebDriver driver = new ChromeDriver(ch);
	
	driver.get("http://www.google.lk");
	driver.findElement(By.name("q")).sendKeys("Selenium");
	driver.findElement(By.name("btnK")).click();
	driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
	String strTitle = driver.getTitle();
	assertEquals(strTitle, "Selenium - Web Browser Automation");
	System.out.print("test done");
}


}
