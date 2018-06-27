package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import org.openqa.selenium.chrome.*;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;

public class Search {
	
	WebDriver driver;
	
	@Given("^User goes to google$")
	public void user_goes_to_google() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		
		 driver.get("http://www.google.lk"); 
	
	}

	@When("^User search 'Selenium'$")
	public void user_search_Selenium() throws Exception {
	   driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
	   driver.findElement(By.name("btnK")).click();
	
	  
	}

	@Then("^User should get the 'Selenium HQ site' in the results page$")
	public void user_should_get_the_Selenium_HQ_site_in_the_results_page() throws Exception {
	  driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
	  Assert.assertEquals("Selenium - Web Browser Automation", driver.getTitle());
	  
	 
	}

}
