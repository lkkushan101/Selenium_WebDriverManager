package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.openqa.selenium.NoSuchElementException;
import ExtentReport.ExtentReport;
import PageFactory.*;
import ReadExcel.ExcelRead;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class LoginScenario {
	     WebDriver driver;

	    Login objLogin;

	    HomePage objHomePage;
	
	    ExtentReport extRpt = new ExtentReport();
	    ExcelRead excel = new ExcelRead();
	    Logger log = Logger.getLogger("devpinoyLogger");
	   
	    
	
	@Given("^I have user name and password$")
	public void i_have_user_name_and_password() throws Throwable {
		 try {
		   System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		   System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
	       
		    
		    String browserMode = excel.readExcel(1,4, ".\\Data\\data.xlsx","Sheet1");
		    if (browserMode.equals("Chrome-Headless"))
		    {
		    	ChromeOptions ch = new ChromeOptions();
		    	ch.addArguments("headless");
		    	ch.addArguments("window-size=1200x600");
		    	
		         driver = new ChromeDriver(ch);
		    }
		    else if (browserMode.equals("Chrome"))
		    {
		    	 driver = new ChromeDriver();
		    }
		    else if (browserMode.equals("Firefox"))
		    {
		    	
		    	driver = new FirefoxDriver();
		    }
		    else if (browserMode.equals("Firefox-Headless"))
		    {
		    	System.setProperty("webdriver.gecko.driver", "C:\\gekhodriver\\geckodriver.exe");
		    	FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
				
			   driver  = new FirefoxDriver(options);
		    }
		    
		    

	        driver.get(excel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1"));
	        log.debug("Navigating to Login Page");
	        extRpt.setUpReport();
		 }
		 catch (NoSuchElementException e)
		 {
			 log.error("Element was not found");
			    extRpt.logFail("Element was not found");
		 }
	  
	}
	@When("^I successfully login$")
	public void i_successfully_login() throws Throwable {
	     try {
		   extRpt.startTestCase("User Login");
	
		    objLogin = new Login(driver);

		    //Verify login page title

		   
		    
		    String loginPageTitle = objLogin.getLoginTitle();

		    Assert.assertTrue(loginPageTitle.toLowerCase().contains(excel.readExcel(1,3, ".\\Data\\data.xlsx","Sheet1")));

		    //login to application

		    objLogin.loginToGuru99(excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"), excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"));
		    log.debug("Entered the user name and password");
		    extRpt.logEvents("Logged Successfully");
	     }
	     catch (NoSuchElementException e)
	     {
	    	    log.error("Element was not found");
			    extRpt.logFail("Element was not found");
	     }

	   
	}
	
	@Then("^I should navigate to the home page$")
	public void i_should_navigate_to_the_home_page() throws Throwable {
		
		try {
		
		objHomePage = new HomePage(driver);

		    //Verify home page

		 objHomePage = new HomePage(driver);

		    //Verify home page

		    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
		    driver.close();
		    extRpt.createFinalReport();
		    log.debug("Creating final report");
		}
		catch (NoSuchElementException e)
		{
			 log.error("Element was not found");
			    extRpt.logFail("Element was not found");
		}
	
	}

}
