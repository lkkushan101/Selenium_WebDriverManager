package stepdefs;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class GoogleSearch {
	WebDriver driver;
	@Given("^I'm in the google search page$")
	public void i_m_in_the_google_search_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.lk");
	}

	@When("^user search Selenium$")
	public void user_search_Selenium() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
		driver.findElement(By.name("btnK")).click(); 
	}

	@Then("^I should get selenium HQ link in search$")
	public void i_should_get_selenium_HQ_link_in_search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
		
		String webTitle = driver.getTitle();
		
		assertEquals("Selenium - Web Browser Automation", webTitle);
		
		driver.close();
		driver.quit();
	}

	
}
