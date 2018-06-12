package Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.*;
import ApachePOI.*;

public class Test {
	
	WebDriver driver;
	
	@BeforeClass
	
	public void testSteps()
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
	
	}
	
	
	
	 @org.testng.annotations.Test()
	public void testScenario () throws IOException
	{
		ExcelRead excelRead = new ExcelRead();
		
		//readExcel(int row,int col, String fileName,String sheetName)
		driver.get(excelRead.readExcel(1,0,"C:\\Config.xlsx","Sheet1"));
		driver.findElement(By.id("lst-ib")).sendKeys(excelRead.readExcel(1,1,"C:\\Config.xlsx","Sheet1"));
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.linkText(excelRead.readExcel(1,2,"C:\\Config.xlsx","Sheet1"))).click();
	}
	

}
