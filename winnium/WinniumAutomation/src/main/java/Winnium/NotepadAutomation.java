package Winnium;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NotepadAutomation {
	 WiniumDriver driver = null;
	 
	 @BeforeClass
	 public void Setup () throws InterruptedException
	 {
	  DesktopOptions desktop = new DesktopOptions();
	  desktop.setApplicationPath("C:\\Windows\\System32\\notepad.exe");
	  try {
		  desktop.setDebugConnectToRunningApp(false);
		  desktop.setLaunchDelay(2);
	   driver = new WiniumDriver(new URL ("http://localhost:9999"), desktop);
	   Thread.sleep(1000);
	  }catch (MalformedURLException e)
	  {
	   e.printStackTrace();
	  }
	 }
	 
	 @Test
	 public void testcase ()
	 {
		 driver.findElementByClassName("Edit").sendKeys("Kushan's Winnium Test");
	 }
	 
	 @AfterClass 
	 
	 public void TearDown()
	 {
	  driver.close();
	 }
}
