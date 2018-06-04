package GekoHeadlessPkg;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class GekoHeadlessClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\gekhodriver\\geckodriver.exe");
		
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		
		WebDriver driver  = new FirefoxDriver(options);
		driver.get("http://www.google.lk");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
		String strTitle = driver.getTitle();
		assertEquals(strTitle, "Selenium - Web Browser Automation");
		
		
		System.out.println("Test Completed");
	}
}
